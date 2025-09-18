package kg.mlsp.ubk.service;

import kg.mlsp.common.dto.person.PersonDto;
import kg.mlsp.common.dto.person.PersonFindDto;
import kg.mlsp.ubk.dto.application.UbkApplicationCreateDto;
import kg.mlsp.ubk.dto.application.UbkApplicationDto;
import kg.mlsp.ubk.dto.application.UbkApplicationFilterDto;
import kg.mlsp.ubk.dto.application.UbkApplicationListDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;


public interface UbkApplicationService {

    PersonDto findPerson(PersonFindDto findDto);

    UbkApplicationDto create(UbkApplicationCreateDto createDto);
    UbkApplicationDto update(Integer id, UbkApplicationCreateDto createDto);
    UbkApplicationDto getById(Integer id);
    Page<UbkApplicationListDto> getAll(UbkApplicationFilterDto filterDto, Pageable pageable);
    String delete(Integer id);

}
