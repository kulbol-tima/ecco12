package kg.mlsp.ubk.service.integration;

import kg.mlsp.integration.dto.asb.AsbGetAddressResponseDto;
import kg.mlsp.integration.dto.cadastr.CadastrAllPropByPinResponseDto;
import kg.mlsp.integration.dto.cissp.CisspGetMsecDetailsResponseDto;
import kg.mlsp.integration.dto.passportinfo.PassportByPsnResponseDto;
import kg.mlsp.integration.dto.socialfund.SfGetPensionInfoWithSumResponseDto;
import kg.mlsp.integration.dto.socialfund.SfGetWorkPeriodInfoResponseDto;
import kg.mlsp.integration.dto.tax.TaxGetPatentsByPinResponseDto;
import kg.mlsp.integration.dto.tax.TaxTpBusinessActivityByPinResponseDto;
import kg.mlsp.integration.dto.zags.ZagsDataByPinResponseDto;
import kg.mlsp.ubk.dto.application.UbkIntegrationDataAllResultDto;

import java.util.List;

public interface UbkIntegrationDataService {

    UbkIntegrationDataAllResultDto runAll(Integer applicationId);
    CisspGetMsecDetailsResponseDto msecData(Integer applicationId);
    PassportByPsnResponseDto passportData(Integer applicationId);
    ZagsDataByPinResponseDto zagsData(Integer applicationId);
    AsbGetAddressResponseDto factAddressData(Integer applicationId);
    SfGetPensionInfoWithSumResponseDto pensionData(Integer applicationId);
    SfGetWorkPeriodInfoResponseDto employmentPeriodData(Integer applicationId);
    TaxTpBusinessActivityByPinResponseDto individualEntrepreneurData(Integer applicationId);
    List<TaxGetPatentsByPinResponseDto> patentData(Integer applicationId);
    List<CadastrAllPropByPinResponseDto>  cadastrObjectData(Integer applicationId);

}
