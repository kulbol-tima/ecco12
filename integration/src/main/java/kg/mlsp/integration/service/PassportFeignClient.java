package kg.mlsp.integration.service;

import kg.mlsp.integration.config.IntegrationClientConfig;
import kg.mlsp.integration.dto.passportinfo.PassportByPsnResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "passportFeignClient",
        url = "${integration-api.base-url}",
        configuration = IntegrationClientConfig.class
)
public interface PassportFeignClient {
    @GetMapping(path = "passport-data-by-psn")
    PassportByPsnResponseDto getDataByPsn(@RequestParam("pin") String pin,
                                          @RequestParam("series") String series,
                                          @RequestParam("number") String number);

}
