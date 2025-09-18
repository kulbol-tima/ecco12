package kg.mlsp.integration.service;

import kg.mlsp.integration.config.IntegrationClientConfig;
import kg.mlsp.integration.dto.cissp.CisspGetMsecDetailsResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "cisspFeignClient",
        url = "${integration-api.base-url}",
        configuration = IntegrationClientConfig.class
)
public interface CisspFeignClient {
    @GetMapping(path = "get-msec-details")
    CisspGetMsecDetailsResponseDto getMsecDetails(@RequestParam("pin") String pin);
}
