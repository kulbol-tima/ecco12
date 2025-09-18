package kg.mlsp.integration.service;

import kg.mlsp.integration.config.IntegrationClientConfig;
import kg.mlsp.integration.config.IntegrationFeignErrorDecoder;
import kg.mlsp.integration.dto.zags.ZagsDataByPinResponseDto;
import kg.mlsp.integration.dto.zags.ZagsDeathActByPinResponseDto;
import org.springframework.web.bind.annotation.*;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(
        name = "zagsFeignClient",
        url = "${integration-api.base-url}",
        configuration = {IntegrationClientConfig.class, IntegrationFeignErrorDecoder.class}
)
public interface ZagsFeignClient {
    @GetMapping(path = "get-data-by-pin")
    ZagsDataByPinResponseDto getDataByPin(@RequestParam("pin") String pin);

    @GetMapping(path = "get-death-act-data-by-pin")
    ZagsDeathActByPinResponseDto getDeathActByPin(@RequestParam("pin") String pin);
}
