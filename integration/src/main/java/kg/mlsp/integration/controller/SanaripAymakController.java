package kg.mlsp.integration.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import kg.mlsp.integration.dto.sanaripaymak.SanaripAymakGetAddressFactResponseDto;
import kg.mlsp.integration.dto.sanaripaymak.SanaripAymakGetFamilyMembersResponseDto;
import kg.mlsp.integration.service.SanaripAymakFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Tag(name = "АИС «Санарип аймак»")
@RequestMapping(BaseIntegrationApiController.BASE_API_PATH + "/sanarip-aymak")
public class SanaripAymakController {

    private final SanaripAymakFeignClient sanaripAymakFeignClient;

    @GetMapping("/get-family-members")
    public SanaripAymakGetFamilyMembersResponseDto getFamilyMembers(@RequestParam("pin") String pin) {
        return sanaripAymakFeignClient.getFamilyMembers(pin);
    }

    @GetMapping("/get-address-fact")
    public SanaripAymakGetAddressFactResponseDto getAddressFact(@RequestParam("pin") String pin) {
        return sanaripAymakFeignClient.getAddressFact(pin);
    }

}