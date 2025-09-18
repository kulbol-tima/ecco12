package kg.mlsp.common.mapper;

import kg.mlsp.common.dto.person.PersonDto;
import kg.mlsp.common.dto.person.PersonShortDto;
import kg.mlsp.common.model.RegPerson;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring", uses = {RefGeneralMapper.class, PersonIdentityMapper.class})
public interface PersonMapper {
    PersonDto toDto(RegPerson person);
    PersonShortDto toDtoShort(RegPerson person);
    List<PersonDto> toDtoList(List<RegPerson> list);
}
