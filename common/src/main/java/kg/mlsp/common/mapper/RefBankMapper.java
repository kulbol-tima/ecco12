package kg.mlsp.common.mapper;

import kg.mlsp.common.dto.reference.RefBankDto;
import kg.mlsp.common.model.reference.RefBank;

import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RefBankMapper {
    RefBankDto toDto(RefBank refBank);
}
