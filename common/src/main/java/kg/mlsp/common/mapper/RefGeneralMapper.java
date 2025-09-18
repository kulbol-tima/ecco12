package kg.mlsp.common.mapper;

import kg.mlsp.common.dto.reference.RefGeneralDto;
import kg.mlsp.common.model.reference.*;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RefGeneralMapper {
    RefGeneralDto toDto(BaseRef baseRef);

    List<RefGeneralDto> toDtoList(List<BaseRef> list);

    default RefGeneralDto toDto(RefAppRequestType ref) {
        var refDto = toDto((BaseRef) ref);
        refDto.setId(refDto.getId());
        return refDto;
    }

    default RefGeneralDto toDto(RefCountry ref) {
        return toDto((BaseRef) ref);
    }

    default RefGeneralDto toDto(RefDistrict ref) {
        return toDto((BaseRef) ref);
    }

    default RefGeneralDto toDto(RefDocumentSerial ref) {
        return toDto((BaseRef) ref);
    }
    default RefGeneralDto toDto(RefEducationLevel ref) {
        return toDto((BaseRef) ref);
    }

    default RefGeneralDto toDto(RefEmploymentType ref) {
        return toDto((BaseRef) ref);
    }

    default RefGeneralDto toDto(RefExtensionType ref) {
        return toDto((BaseRef) ref);
    }

    default RefGeneralDto toDto(RefGender ref) {
        return toDto((BaseRef) ref);
    }

    default RefGeneralDto toDto(RefIncomeType ref) {
        return toDto((BaseRef) ref);
    }

    default RefGeneralDto toDto(RefMaritalStatus ref) {
        return toDto((BaseRef) ref);
    }

    default RefGeneralDto toDto(RefNationality ref) {
        return toDto((BaseRef) ref);
    }

    default RefGeneralDto toDto(RefOrganization ref) {
        return toDto((BaseRef) ref);
    }

    default RefGeneralDto toDto(RefPersonCategoryType ref) {
        return toDto((BaseRef) ref);
    }

    default RefGeneralDto toDto(RefPersonDocumentType ref) {
        return toDto((BaseRef) ref);
    }

    default RefGeneralDto toDto(RefRegion ref) {
        return toDto((BaseRef) ref);
    }

    default RefGeneralDto toDto(RefRejectionReason ref) {
        return toDto((BaseRef) ref);
    }

    default RefGeneralDto toDto(RefRelationshipType ref) {
        return toDto((BaseRef) ref);
    }

    default RefGeneralDto toDto(RefStatus ref) {
        return toDto((BaseRef) ref);
    }
}
