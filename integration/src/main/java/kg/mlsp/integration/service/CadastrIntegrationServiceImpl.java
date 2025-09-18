package kg.mlsp.integration.service;

import kg.mlsp.integration.dto.cadastr.CadastrAllPropByPinResponseDto;
import kg.mlsp.integration.dto.cadastr.CadastrSearchAllByPropCodeResponseDto;
import kg.mlsp.integration.dto.cadastr.CadastrSearchPinAllResponseDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CadastrIntegrationServiceImpl implements CadastrIntegrationService {
    private final CadastrFeignClient cadastrFeignClient;

    private List<CadastrAllPropByPinResponseDto> getCadastrAllPropByPinResponseDtos(List<CadastrSearchPinAllResponseDto> properties) {
        return properties.stream()
                .map(property -> {
                    List<CadastrSearchAllByPropCodeResponseDto> details = cadastrFeignClient.searchAllByPropCode(property.getPropcode());
                    if (!details.isEmpty()) {
                        CadastrAllPropByPinResponseDto responseDto = new CadastrAllPropByPinResponseDto();
                        responseDto.setPropcode(property.getPropcode());
                        responseDto.setAddress(property.getAddress());
                        responseDto.setOwner(property.getOwner());
                        responseDto.setPin(property.getPin());
                        responseDto.setDocNum(property.getDocNum());
                        responseDto.setRegDate(property.getRegDate());
                        responseDto.setTermDate(property.getTermDate());

                        CadastrSearchAllByPropCodeResponseDto detail = details.getFirst();
                        responseDto.setMaterialsten(detail.getMaterialsten());
                        responseDto.setPloshadStroenia(detail.getPloshadStroenia());
                        responseDto.setPloshadZemUchastka(detail.getPloshadZemUchastka());
                        responseDto.setUnitZemUchastka(detail.getUnitZemUchastka());
                        responseDto.setGodPostroiki(detail.getGodPostroiki());
                        responseDto.setFormaSobstvenosti(detail.getFormaSobstvenosti());
                        responseDto.setNaznachenie(detail.getNaznachenie());
                        responseDto.setFormaIspolzovania(detail.getFormaIspolzovania());
                        return responseDto;
                    }
                    return null;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());
    }

    @Override
    public List<CadastrAllPropByPinResponseDto> searchAllPropByPin(String pin) {
        List<CadastrSearchPinAllResponseDto> properties = cadastrFeignClient.searchPinAll(pin);

        return getCadastrAllPropByPinResponseDtos(properties);
    }

    @Override
    public List<CadastrAllPropByPinResponseDto> searchAllPropByFullName(String surName, String firstName) {
        List<CadastrSearchPinAllResponseDto>  properties = cadastrFeignClient.searchAllByFullName(surName, firstName);

        return getCadastrAllPropByPinResponseDtos(properties);
    }
}
