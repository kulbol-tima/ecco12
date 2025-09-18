package kg.mlsp.integration.service;

import kg.mlsp.integration.config.IntegrationClientConfig;
import kg.mlsp.integration.dto.socialfund.SfGetPensionInfoResponseDto;
import kg.mlsp.integration.dto.socialfund.SfGetPensionInfoWithSumResponseDto;
import kg.mlsp.integration.dto.socialfund.SfGetWorkPeriodInfoResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "SocialFundFeignClient",
        url = "${integration-api.base-url}",
        configuration = IntegrationClientConfig.class
)
public interface SocialFundFeignClient {
    @GetMapping(path = "get-work-period-info")
    SfGetWorkPeriodInfoResponseDto getWorkPeriodInfo(@RequestParam("pin") String pin,
                                                           @RequestParam("lastMonths") Integer lastMonths);

    @GetMapping(path = "get-pension-info")
    SfGetPensionInfoResponseDto getPensionInfo(@RequestParam("pin") String pin);


    @GetMapping(path = "get-pension-info-with-sum")
    SfGetPensionInfoWithSumResponseDto getPensionInfoWithSum(@RequestParam("pin") String pin);



}
