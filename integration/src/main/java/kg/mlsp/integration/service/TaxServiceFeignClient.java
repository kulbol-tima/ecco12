package kg.mlsp.integration.service;

import kg.mlsp.integration.config.IntegrationClientConfig;
import kg.mlsp.integration.dto.tax.TaxGetPatentsByPinResponseDto;
import kg.mlsp.integration.dto.tax.TaxTpBusinessActivityByPinResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(
        name = "taxServiceFeignClient",
        url = "${integration-api.base-url}",
        configuration = IntegrationClientConfig.class
)
public interface TaxServiceFeignClient {
    /**
     * AIS GNS.
     */
    @GetMapping(path = "tp-business-activity-by-pin")
    TaxTpBusinessActivityByPinResponseDto tpBusinessActivityByPin(@RequestParam("pin") String pin);

    /**
     * AIS PATENT/POLIS.
     */
    @GetMapping(path = "get-patents-by-pin")
    List<TaxGetPatentsByPinResponseDto> getPatentsByPin(@RequestParam("pin") String pin,
                                                        @RequestParam("dateCurrent") Boolean dateCurrent);

}
