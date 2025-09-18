package kg.mlsp.integration.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import kg.mlsp.integration.dto.cissp.CisspGetMsecDetailsResponseDto;
import kg.mlsp.integration.service.CisspFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Tag(name = "АИС «КИССП»")
@RequestMapping(BaseIntegrationApiController.BASE_API_PATH + "/cissp")
public class CisspController {

    private final CisspFeignClient cisspFeignClient;

    @GetMapping("/get-msec-details")
    public CisspGetMsecDetailsResponseDto getWorkPeriodInfo(@RequestParam("pin") String pin) {
        return cisspFeignClient.getMsecDetails(pin);
    }
}