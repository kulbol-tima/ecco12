package kg.mlsp.ubk.mapper;

import kg.mlsp.common.service.PersonMapperService;
import kg.mlsp.common.service.ReferenceMapperService;
import kg.mlsp.ubk.dto.application.UbkApplicationDto;
import kg.mlsp.ubk.dto.application.UbkApplicationListDto;
import kg.mlsp.ubk.model.UbkApplication;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public abstract class UbkApplicationMapper {

    @Autowired
    private ReferenceMapperService referenceMapperService;

    @Autowired
    private PersonMapperService personMapperService;

    public abstract UbkApplicationDto toDto(UbkApplication application);
    public abstract UbkApplicationListDto toDtoList(UbkApplication list);

    @AfterMapping
    protected void enrichList(@MappingTarget UbkApplicationListDto dtoList, UbkApplication entity) {
        if (entity.getApplicantId() != null){
            dtoList.setApplicant(personMapperService.getPersonShort(entity.getApplicantId()));
        }

        if (entity.getStatusId() != null) {
            dtoList.setStatus(referenceMapperService.getStatusById(entity.getStatusId()));
        }

        if (entity.getRequestTypeId() != null) {
            dtoList.setRequestType(referenceMapperService.getRequestTypeById(entity.getRequestTypeId()));
        }
    }

    @AfterMapping
    protected void enrich(@MappingTarget UbkApplicationDto dto, UbkApplication entity) {

        if (entity.getOrganizationId() != null){
            dto.setOrganization(referenceMapperService.getOrganizationById(entity.getOrganizationId()));
        }

        if (entity.getApplicantId() != null){
            dto.setApplicant(personMapperService.getPerson(entity.getApplicantId()));
        }

        if (entity.getStatusId() != null) {
            dto.setStatus(referenceMapperService.getStatusById(entity.getStatusId()));
        }

        if (entity.getRequestTypeId() != null) {
            dto.setRequestType(referenceMapperService.getRequestTypeById(entity.getRequestTypeId()));
        }

        if (entity.getEmploymentTypeId() != null) {
            dto.setEmploymentType(referenceMapperService.getEmploymentTypeById(entity.getEmploymentTypeId()));
        }

        if (entity.getMaritalStatusId() != null) {
            dto.setMaritalStatus(referenceMapperService.getMartialStatusById(entity.getMaritalStatusId()));
        }

        if (entity.getPersonCategoryId() != null) {
            dto.setPersonCategory(referenceMapperService.getPersonDocumentTypeById(entity.getPersonCategoryId()));
        }
    }
}
