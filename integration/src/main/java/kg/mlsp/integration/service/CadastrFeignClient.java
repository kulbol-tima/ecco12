package kg.mlsp.integration.service;

import kg.mlsp.integration.config.IntegrationClientConfig;
import kg.mlsp.integration.dto.cadastr.CadastrSearchPinAllResponseDto;
import kg.mlsp.integration.dto.cadastr.CadastrSearchAllByPropCodeResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(
        name = "cadastrFeignClient",
        url = "${integration-api.base-url}",
        configuration = IntegrationClientConfig.class
)
public interface CadastrFeignClient {
    @GetMapping(path = "search-pin-all")
    List<CadastrSearchPinAllResponseDto> searchPinAll(@RequestParam("pin") String pin);

    @GetMapping(path = "search-all-by-prop-code")
    List<CadastrSearchAllByPropCodeResponseDto> searchAllByPropCode(@RequestParam("propCode") String propCode);

    @GetMapping(path = "search-all-by-full-name")
    List<CadastrSearchPinAllResponseDto> searchAllByFullName(
            @RequestParam("surname") String surname, @RequestParam("firstname") String firstname
    );

}
