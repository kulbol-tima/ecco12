package kg.mlsp.ubk.mapper;

import kg.mlsp.common.service.ReferenceMapperService;
import kg.mlsp.ubk.dto.application.UbkApplicationHistoryDto;
import kg.mlsp.ubk.model.UbkApplicationHistory;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class UbkApplicationHistoryMapper {

    @Autowired
    private ReferenceMapperService referenceMapperService;

    public abstract List<UbkApplicationHistoryDto> toDtoList(List<UbkApplicationHistory> list);


    @AfterMapping
    protected void enrich(@MappingTarget UbkApplicationHistoryDto dto, UbkApplicationHistory entity) {

        if (entity.getStatusId() != null) {
            dto.setStatus(referenceMapperService.getStatusById(entity.getStatusId()));
        }

        if (entity.getOldStatusId() != null) {
            dto.setOldStatus(referenceMapperService.getStatusById(entity.getOldStatusId()));
        }

        if (entity.getRejectionReasonId() != null) {
            dto.setRejectionReason(referenceMapperService.getStatusById(entity.getRejectionReasonId()));
        }
    }
}
