package kg.mlsp.integration.service;

import kg.mlsp.integration.config.IntegrationClientConfig;
import kg.mlsp.integration.dto.sanaripaymak.SanaripAymakGetAddressFactResponseDto;
import kg.mlsp.integration.dto.sanaripaymak.SanaripAymakGetFamilyMembersResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(
        name = "sanaripAymakFeignClient",
        url = "${integration-api.base-url}",
        configuration = IntegrationClientConfig.class
)
public interface SanaripAymakFeignClient {
    @GetMapping(path = "get-family-members")
    SanaripAymakGetFamilyMembersResponseDto getFamilyMembers(@RequestParam("pin") String pin);

    @GetMapping(path = "get-address-fact")
    SanaripAymakGetAddressFactResponseDto getAddressFact(@RequestParam("pin") String pin);

}
