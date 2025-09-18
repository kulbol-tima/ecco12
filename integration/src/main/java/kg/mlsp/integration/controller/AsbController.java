package kg.mlsp.integration.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import kg.mlsp.integration.dto.asb.AsbGetAddressResponseDto;
import kg.mlsp.integration.service.AsbFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Tag(name = "АИС «АСБ»")
@RequestMapping(BaseIntegrationApiController.BASE_API_PATH + "/asb")
public class AsbController {

    private final AsbFeignClient asbFeignClient;

    @GetMapping("/get-address")
    public AsbGetAddressResponseDto getAddress(@RequestParam("pin") String pin) {
        return asbFeignClient.getAsbAddress(pin);
    }
}