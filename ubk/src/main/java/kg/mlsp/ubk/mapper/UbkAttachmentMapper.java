package kg.mlsp.ubk.mapper;

import kg.mlsp.common.service.ReferenceMapperService;
import kg.mlsp.ubk.dto.application.UbkAttachmentDto;
import kg.mlsp.ubk.model.UbkAttachment;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


//Приклипленные файлы к заявке
@Mapper(componentModel = "spring")
public abstract class UbkAttachmentMapper {

    @Autowired
    private ReferenceMapperService referenceMapperService;
    public abstract UbkAttachmentDto toDto(UbkAttachment requisites);

    public abstract List<UbkAttachmentDto> toDtoList(List<UbkAttachment> list);


    @AfterMapping
    protected void enrich(@MappingTarget UbkAttachmentDto dto, UbkAttachment entity) {
        if (entity.getDocumentTypeId() != null) {
            dto.setDocumentType(referenceMapperService.getDocumentTypeById(entity.getDocumentTypeId()));
        }
    }
}