package kg.mlsp.integration.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import kg.mlsp.integration.dto.tax.TaxGetPatentsByPinResponseDto;
import kg.mlsp.integration.dto.tax.TaxTpBusinessActivityByPinResponseDto;
import kg.mlsp.integration.service.TaxServiceFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Tag(name = "АИС «ГНС» и АИС «Патент/Полис»")
@RequestMapping(BaseIntegrationApiController.BASE_API_PATH + "/tax")
public class TaxServiceController {

    private final TaxServiceFeignClient taxServiceClient;

    @GetMapping("/tp-business-activity-by-pin")
    public TaxTpBusinessActivityByPinResponseDto searchByPin(@RequestParam("pin") String pin) {
        return taxServiceClient.tpBusinessActivityByPin(pin);
    }

    @GetMapping("/get-patents-by-pin")
    public List<TaxGetPatentsByPinResponseDto> getPatentsByPin(@RequestParam("pin") String pin,
                                                               @RequestParam("dateCurrent") boolean dateCurrent) {
        return taxServiceClient.getPatentsByPin(pin, dateCurrent);
    }
}