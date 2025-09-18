package kg.mlsp.integration.service;

import kg.mlsp.integration.dto.cadastr.CadastrAllPropByPinResponseDto;

import java.util.List;

public interface CadastrIntegrationService {
    List<CadastrAllPropByPinResponseDto> searchAllPropByPin(String pin);
    List<CadastrAllPropByPinResponseDto> searchAllPropByFullName(String firstName, String lastName);
}
