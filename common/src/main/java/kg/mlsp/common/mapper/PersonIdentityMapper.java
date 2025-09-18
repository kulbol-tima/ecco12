package kg.mlsp.common.mapper;

import kg.mlsp.common.dto.person.PersonIdentityDto;
import kg.mlsp.common.model.RegPersonIdentity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PersonIdentityMapper {
    PersonIdentityDto toDto(RegPersonIdentity personIdentity);
}
