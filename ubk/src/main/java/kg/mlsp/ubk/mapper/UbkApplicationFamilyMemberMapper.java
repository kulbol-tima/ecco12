package kg.mlsp.ubk.mapper;

import kg.mlsp.common.service.PersonMapperService;
import kg.mlsp.common.service.ReferenceMapperService;
import kg.mlsp.ubk.dto.familymember.UbkApplicationFamilyMemberDto;
import kg.mlsp.ubk.model.UbkApplicationFamilyMember;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class UbkApplicationFamilyMemberMapper {

    @Autowired
    private ReferenceMapperService referenceMapperService;

    @Autowired
    private PersonMapperService personMapperService;


    public abstract  UbkApplicationFamilyMemberDto toDto(UbkApplicationFamilyMember familyMember);
    public abstract  List<UbkApplicationFamilyMemberDto> toDtoList(List<UbkApplicationFamilyMember> list);


    @AfterMapping
    protected void enrich(@MappingTarget UbkApplicationFamilyMemberDto dto, UbkApplicationFamilyMember entity) {

        if (entity.getFamilyMemberId() != null) {
            dto.setFamilyMember(personMapperService.getPerson(entity.getFamilyMemberId()));
        }
        if (entity.getEmploymentTypeId() != null) {
            dto.setEmploymentType(referenceMapperService.getEmploymentTypeById(entity.getEmploymentTypeId()));
        }

        if (entity.getRelationshipTypeId() != null) {
            dto.setRelationshipType(referenceMapperService.getRelationshipTypeById(entity.getRelationshipTypeId()));
        }

        if (entity.getPersonCategoryId() != null) {
            dto.setPersonCategory(referenceMapperService.getPersonCategoryById(entity.getPersonCategoryId()));
        }

        if (entity.getCitizenshipId() != null) {
            dto.setCitizenship(referenceMapperService.getCountryById(entity.getCitizenshipId()));
        }

    }
}
