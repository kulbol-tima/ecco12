package kg.mlsp.integration.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import kg.mlsp.integration.dto.passportinfo.PassportByPsnResponseDto;
import kg.mlsp.integration.service.PassportFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Tag(name = "АИС «Паспорт»")
@RequestMapping(BaseIntegrationApiController.BASE_API_PATH + "/passport")
public class PassportController extends BaseIntegrationApiController {

    private final PassportFeignClient passportFeignClient;

    @GetMapping("/data-by-psn")
    public PassportByPsnResponseDto getDataByPsn(@RequestParam("pin") String pin,
                                                 @RequestParam("series") String series,
                                                 @RequestParam("number") String number) {
        return passportFeignClient.getDataByPsn(pin, series, number);
    }

}
