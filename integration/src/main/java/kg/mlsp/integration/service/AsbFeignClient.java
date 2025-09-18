package kg.mlsp.integration.service;

import kg.mlsp.integration.config.IntegrationClientConfig;
import kg.mlsp.integration.dto.asb.AsbGetAddressResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient(
        name = "asbFeignClient",
        url = "${integration-api.base-url}",
        configuration = IntegrationClientConfig.class
)
public interface AsbFeignClient {
    @GetMapping(path = "asb_address")
    AsbGetAddressResponseDto getAsbAddress(@RequestParam("pin") String pin);

}
