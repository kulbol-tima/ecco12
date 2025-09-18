package kg.mlsp.ubk.service;

import kg.mlsp.ubk.dto.income.UbkApplicationIncomeCreateDto;
import kg.mlsp.ubk.dto.income.UbkApplicationIncomeDto;

import java.util.List;

public interface UbkApplicationIncomeService {
    UbkApplicationIncomeDto create(Integer applicationId, UbkApplicationIncomeCreateDto createDto);
    UbkApplicationIncomeDto update(Integer id, UbkApplicationIncomeCreateDto createDto);
    UbkApplicationIncomeDto getById(Integer id);
    List<UbkApplicationIncomeDto> list(Integer applicationId);
    String delete(Integer id);
}
