package kg.mlsp.ubk.service.integration;

import kg.mlsp.common.model.RegPerson;
import kg.mlsp.common.repository.PersonRepository;
import kg.mlsp.integration.dto.asb.AsbGetAddressResponseDto;
import kg.mlsp.integration.dto.cadastr.CadastrAllPropByPinResponseDto;
import kg.mlsp.integration.dto.cissp.CisspGetMsecDetailsResponseDto;
import kg.mlsp.integration.dto.passportinfo.PassportByPsnResponseDto;
import kg.mlsp.integration.dto.socialfund.SfGetPensionInfoWithSumResponseDto;
import kg.mlsp.integration.dto.socialfund.SfGetWorkPeriodInfoResponseDto;
import kg.mlsp.integration.dto.tax.TaxGetPatentsByPinResponseDto;
import kg.mlsp.integration.dto.tax.TaxTpBusinessActivityByPinResponseDto;
import kg.mlsp.integration.dto.zags.ZagsDataByPinResponseDto;
import kg.mlsp.integration.service.*;
import kg.mlsp.ubk.dto.application.UbkIntegrationDataAllResultDto;
import kg.mlsp.ubk.model.UbkApplication;
import kg.mlsp.ubk.repository.UbkApplicationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UbkIntegrationDataServiceImp implements UbkIntegrationDataService {

    private final UbkApplicationRepository ubkApplicationRepository;
    private final PersonRepository personRepository;
    private final CisspFeignClient cisspFeignClient;
    private final PassportFeignClient passportFeignClient;
    private final ZagsFeignClient zagsFeignClient;
    private final AsbFeignClient asbFeignClient;
    private final TaxServiceFeignClient taxServiceFeignClient;
    private final SocialFundFeignClient socialFundFeignClient;
    private final CadastrIntegrationService cadastrIntegrationService;

    //Данные из ГРС: Паспортная база
    @Override
    public PassportByPsnResponseDto passportData(Integer applicationId) {
        RegPerson applicant = findPersonById(applicationId);
        if (applicant.getPassportSeries() == null){
            applicant.setPassportSeries(applicant.getRefDocumentSerial() != null ?
                    applicant.getRefDocumentSerial().getCode() : null);
        }
        return passportFeignClient.getDataByPsn(applicant.getPin(),
                applicant.getPassportSeries(),
                applicant.getPassportNumber());
    }

    //Данные из ГРС: ЗАГС база
    @Override
    public CisspGetMsecDetailsResponseDto msecData(Integer applicationId) {
        RegPerson applicant = findPersonById(applicationId);
        return cisspFeignClient.getMsecDetails(applicant.getPin());
    }


    //Данные из ГРС: ЗАГС база
    @Override
    public ZagsDataByPinResponseDto zagsData(Integer applicationId) {
        RegPerson applicant = findPersonById(applicationId);
        return zagsFeignClient.getDataByPin(applicant.getPin());
    }

    //Данные из ГРС: Адрес фактического места жительства (АСБ)
    @Override
    public AsbGetAddressResponseDto factAddressData(Integer applicationId) {
        RegPerson applicant = findPersonById(applicationId);
        return asbFeignClient.getAsbAddress(applicant.getPin());
    }

    //Данные из СФ: Наличие пенсии
    @Override
    public SfGetPensionInfoWithSumResponseDto pensionData(Integer applicationId) {
        RegPerson applicant = findPersonById(applicationId);
        return socialFundFeignClient.getPensionInfoWithSum(applicant.getPin());
    }

    //Данные из СФ: Информация о периодах работы застрахованного лица
    @Override
    public SfGetWorkPeriodInfoResponseDto employmentPeriodData(Integer applicationId) {
        RegPerson applicant = findPersonById(applicationId);
        Integer lastMonth = LocalDate.now().minusMonths(1).getMonthValue();
        return socialFundFeignClient.getWorkPeriodInfo(applicant.getPin(), lastMonth);
    }


    //Данные из ГНС: Информация о наличии патентач
    @Override
    public List<TaxGetPatentsByPinResponseDto> patentData(Integer applicationId) {
        RegPerson applicant = findPersonById(applicationId);
        return taxServiceFeignClient.getPatentsByPin(applicant.getPin(), true);
    }

    //Данные из ГНС: ИП
    @Override
    public TaxTpBusinessActivityByPinResponseDto individualEntrepreneurData(Integer applicationId) {
        RegPerson applicant = findPersonById(applicationId);
        return taxServiceFeignClient.tpBusinessActivityByPin(applicant.getPin());
    }

    //Данные из ГРС: ЗАГС база
    @Override
    public List<CadastrAllPropByPinResponseDto>  cadastrObjectData(Integer applicationId) {
        RegPerson applicant = findPersonById(applicationId);
        return cadastrIntegrationService.searchAllPropByPin(applicant.getPin());
    }

    @Override
    public UbkIntegrationDataAllResultDto runAll(Integer applicationId) {

        var result = new UbkIntegrationDataAllResultDto();
        result.setRequestStartDate(LocalDateTime.now());

        // МСЭК
        try {
            CisspGetMsecDetailsResponseDto msec = msecData(applicationId);
            result.setMsecDataSuccess(msec != null);
        } catch (Exception e) {
            result.setMsecDataSuccess(false);
            log.error("Ошибка при получении данных МСЭК для applicationId={}", applicationId, e);
        }

        // Паспортные данные
        try {
            PassportByPsnResponseDto passport = passportData(applicationId);
            result.setPassportDataSuccess(passport != null);
        } catch (Exception e) {
            result.setPassportDataSuccess(false);
            log.error("Ошибка при получении паспортных данных для applicationId={}", applicationId, e);
        }

        // ЗАГС
        try {
            ZagsDataByPinResponseDto zags = zagsData(applicationId);
            result.setZagsDataSuccess(zags != null);
        } catch (Exception e) {
            result.setZagsDataSuccess(false);
            log.error("Ошибка при получении данных ЗАГС для applicationId={}", applicationId, e);
        }

        // Фактический адрес
        try {
            AsbGetAddressResponseDto address = factAddressData(applicationId);
            result.setFactAddressDataSuccess(address != null);
        } catch (Exception e) {
            result.setFactAddressDataSuccess(false);
            log.error("Ошибка при получении фактического адреса для applicationId={}", applicationId, e);
        }
        // Пенсия
        try {
            SfGetPensionInfoWithSumResponseDto pension = pensionData(applicationId);
            result.setPensionDataSuccess(pension != null);
        } catch (Exception e) {
            result.setPensionDataSuccess(false);
            log.error("Ошибка при получении данных о пенсии для applicationId={}", applicationId, e);
        }
        // Периоды работы
        try {
            SfGetWorkPeriodInfoResponseDto employment = employmentPeriodData(applicationId);
            result.setEmploymentPeriodDataSuccess(employment != null);
        } catch (Exception e) {
            result.setEmploymentPeriodDataSuccess(false);
            log.error("Ошибка при получении данных о периодах работы для applicationId={}", applicationId, e);
        }
        // Патенты
        try {
            List<TaxGetPatentsByPinResponseDto> patents = patentData(applicationId);
            result.setPatentDataSuccess(patents != null);
        } catch (Exception e) {
            result.setPatentDataSuccess(false);
            log.error("Ошибка при получении данных о патентах для applicationId={}", applicationId, e);
        }
        // ИП
        try {
            TaxTpBusinessActivityByPinResponseDto ie = individualEntrepreneurData(applicationId);
            result.setIndividualEntrepreneurDataSuccess(ie != null);
        } catch (Exception e) {
            result.setIndividualEntrepreneurDataSuccess(false);
            log.error("Ошибка при получении данных об ИП для applicationId={}", applicationId, e);
        }

        // Кадастр
        try {
            List<CadastrAllPropByPinResponseDto> cadastr = cadastrObjectData(applicationId);
            result.setCadastrObjectDataSuccess(cadastr != null);
        } catch (Exception e) {
            result.setCadastrObjectDataSuccess(false);
            log.error("Ошибка при получении данных кадастра для applicationId={}", applicationId, e);
        }


        result.setRequestEndDate(LocalDateTime.now());
        return result;
    }



    private RegPerson findPersonById(Integer applicationId) {

        UbkApplication application = ubkApplicationRepository.findById(applicationId).orElseThrow(
                () -> new RuntimeException("Application not found with id: " + applicationId)
        );
        if (application.getApplicantId() == null) {
            throw new RuntimeException("Applicant ID is null for application id: " + applicationId);
        }
        RegPerson person = personRepository.findById(application.getApplicantId()).orElse(null);
        if (person == null) {
            throw new RuntimeException("Person not found with id: " + application.getApplicantId());
        }
        return person;
    }
}
