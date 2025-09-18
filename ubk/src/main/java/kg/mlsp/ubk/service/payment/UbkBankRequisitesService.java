package kg.mlsp.ubk.service.payment;

import kg.mlsp.ubk.dto.payment.UbkBankRequisitesCreateDto;
import kg.mlsp.ubk.dto.payment.UbkBankRequisitesDto;

import java.util.List;


public interface UbkBankRequisitesService {
    UbkBankRequisitesDto create(Integer applicationId, UbkBankRequisitesCreateDto createDto);
    UbkBankRequisitesDto update(Integer id, UbkBankRequisitesCreateDto createDto);
    UbkBankRequisitesDto getById(Integer id);
    List<UbkBankRequisitesDto> list(Integer applicationId);
    String delete(Integer id);
}
