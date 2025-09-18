package kg.mlsp.integration.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import kg.mlsp.integration.dto.socialfund.SfGetPensionInfoResponseDto;
import kg.mlsp.integration.dto.socialfund.SfGetPensionInfoWithSumResponseDto;
import kg.mlsp.integration.dto.socialfund.SfGetWorkPeriodInfoResponseDto;
import kg.mlsp.integration.service.SocialFundFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Tag(name = "АИС «СФ КР»")
@RequestMapping(BaseIntegrationApiController.BASE_API_PATH + "/social-fund")
public class SocialFundController {

    private final SocialFundFeignClient socialFundClient;

    @GetMapping("/get-work-period-info")
    public SfGetWorkPeriodInfoResponseDto getWorkPeriodInfo(@RequestParam("pin") String pin,
                                                            @RequestParam("lastMonths") Integer lastMonths) {
        return socialFundClient.getWorkPeriodInfo(pin, lastMonths);
    }

    @GetMapping("/get-pension-info")
    public SfGetPensionInfoResponseDto getPensionInfo(@RequestParam("pin") String pin) {
        return socialFundClient.getPensionInfo(pin);
    }

    @GetMapping("/get-pension-info-with-sum")
    public SfGetPensionInfoWithSumResponseDto getPensionInfoWithSum(@RequestParam("pin") String pin) {
        return socialFundClient.getPensionInfoWithSum(pin);
    }
}