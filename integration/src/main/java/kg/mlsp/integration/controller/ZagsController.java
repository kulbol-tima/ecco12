package kg.mlsp.integration.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import kg.mlsp.integration.dto.zags.*;
import kg.mlsp.integration.service.ZagsFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Tag(name = "АИС «ЗАГС»")
@RequestMapping(BaseIntegrationApiController.BASE_API_PATH + "/zags")
public class ZagsController extends BaseIntegrationApiController {

    private final ZagsFeignClient zagsFeignClient;

    @GetMapping("/get-data-by-pin/{pin}")
    public ZagsDataByPinResponseDto getDataByPin(@PathVariable String pin) {
        log.info("Fetching ZAGS data for PIN: {}", pin);
        return zagsFeignClient.getDataByPin(pin);
    }

    @GetMapping("/get-death-act-data-by-pin/{pin}")
    public ZagsDeathActByPinResponseDto getDeathActByPin(@PathVariable String pin) {
        log.info("Fetching ZAGS death act data for PIN: {}", pin);
        return zagsFeignClient.getDeathActByPin(pin);
    }

}
