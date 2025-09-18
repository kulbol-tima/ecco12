package kg.mlsp.integration.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import kg.mlsp.integration.dto.cadastr.CadastrAllPropByPinResponseDto;
import kg.mlsp.integration.dto.cadastr.CadastrSearchPinAllResponseDto;
import kg.mlsp.integration.dto.cadastr.CadastrSearchAllByPropCodeResponseDto;
import kg.mlsp.integration.service.CadastrFeignClient;
import kg.mlsp.integration.service.CadastrIntegrationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RestController
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
@Tag(name = "АИС «Кадастр»")
@RequestMapping(BaseIntegrationApiController.BASE_API_PATH + "/cadastr")
public class CadastrController {

    private final CadastrFeignClient cadastrClient;
    private final CadastrIntegrationService cadastrIntegrationService;

    @GetMapping("/search-pin-all")
    public List<CadastrSearchPinAllResponseDto> searchByPin(@RequestParam("pin") String pin) {
        return cadastrClient.searchPinAll(pin);
    }

    @GetMapping("/search-all-by-prop-code")
    public List<CadastrSearchAllByPropCodeResponseDto> searchAllByPropCode(@RequestParam("propCode") String propCode) {
        return cadastrClient.searchAllByPropCode(propCode);
    }

    @GetMapping("/search-all-by-full-name")
    public List<CadastrSearchPinAllResponseDto> searchAllByFullName(@RequestParam("surname") String surname, @RequestParam("firstname") String firstname) {
        return cadastrClient.searchAllByFullName(surname,  firstname);
    }

    @GetMapping("/search-all-prop-by-pin")
    public List<CadastrAllPropByPinResponseDto> searchPinAllWithPropCode(@RequestParam("pin") String pin) {
        return cadastrIntegrationService.searchAllPropByPin(pin);
    }

    @GetMapping("/search-all-prop-by-full-name")
    public List<CadastrAllPropByPinResponseDto> searchAllPropByFullName(@RequestParam("surname") String surname, @RequestParam("firstname") String firstname) {
        return cadastrIntegrationService.searchAllPropByFullName(surname, firstname);
    }

}