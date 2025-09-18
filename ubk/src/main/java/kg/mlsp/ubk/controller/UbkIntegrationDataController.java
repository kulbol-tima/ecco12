package kg.mlsp.ubk.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
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
import kg.mlsp.ubk.service.integration.UbkIntegrationDataService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/integration-data/{applicationId}")
@Tag(name = "Integration", description = "Integration data management APIs")
public class UbkIntegrationDataController {

    private final UbkIntegrationDataService ubkIntegrationDataService;

    @GetMapping("all")
    public ResponseEntity<UbkIntegrationDataAllResultDto> runAll(@PathVariable Integer applicationId) {
        return ResponseEntity.ok(ubkIntegrationDataService.runAll(applicationId));
    }


    @GetMapping("msec-data")
    public ResponseEntity<CisspGetMsecDetailsResponseDto> msecData(@PathVariable Integer applicationId) {
        return ResponseEntity.ok(ubkIntegrationDataService.msecData(applicationId));
    }

    @GetMapping("passport-data")
    public ResponseEntity<PassportByPsnResponseDto> passportData(@PathVariable Integer applicationId) {
        return ResponseEntity.ok(ubkIntegrationDataService.passportData(applicationId));
    }

    @GetMapping("zags-data")
    public ResponseEntity<ZagsDataByPinResponseDto> zagsData(@PathVariable Integer applicationId) {
        return ResponseEntity.ok(ubkIntegrationDataService.zagsData(applicationId));
    }

    @GetMapping("fact-address-data")
    public ResponseEntity<AsbGetAddressResponseDto> factAddressData(@PathVariable Integer applicationId) {
        return ResponseEntity.ok(ubkIntegrationDataService.factAddressData(applicationId));
    }

    @GetMapping("pension-data")
    public ResponseEntity<SfGetPensionInfoWithSumResponseDto> pensionData(@PathVariable Integer applicationId) {
        return ResponseEntity.ok(ubkIntegrationDataService.pensionData(applicationId));
    }

    //Данные из ГРС: сведения о транспортных средствах
    //Данные из ИСРТ: Статус занятости

    @GetMapping("employment-period-data")
    public ResponseEntity<SfGetWorkPeriodInfoResponseDto> employmentPeriodData(@PathVariable Integer applicationId) {
        return ResponseEntity.ok(ubkIntegrationDataService.employmentPeriodData(applicationId));
    }

    @GetMapping("patent-data")
    public ResponseEntity<List<TaxGetPatentsByPinResponseDto>> patentData(@PathVariable Integer applicationId) {
        return ResponseEntity.ok(ubkIntegrationDataService.patentData(applicationId));
    }

    @GetMapping("individual-entrepreneur-data")
    public ResponseEntity<TaxTpBusinessActivityByPinResponseDto> individualEntrepreneurData(@PathVariable Integer applicationId) {
        return ResponseEntity.ok(ubkIntegrationDataService.individualEntrepreneurData(applicationId));
    }

    @GetMapping("cadastr-object-data")
    public ResponseEntity<List<CadastrAllPropByPinResponseDto>> cadastrObjectData(@PathVariable Integer applicationId) {
        return ResponseEntity.ok(ubkIntegrationDataService.cadastrObjectData(applicationId));
    }

}
