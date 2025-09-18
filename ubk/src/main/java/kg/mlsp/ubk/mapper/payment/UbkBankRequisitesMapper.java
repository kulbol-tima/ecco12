package kg.mlsp.ubk.mapper.payment;

import kg.mlsp.common.service.ReferenceMapperService;
import kg.mlsp.ubk.dto.payment.UbkBankRequisitesDto;
import kg.mlsp.ubk.model.payment.UbkBankRequisites;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


//Банковские реквизиты
@Mapper(componentModel = "spring")
public abstract class UbkBankRequisitesMapper {

    @Autowired
    private ReferenceMapperService referenceMapperService;
    public abstract UbkBankRequisitesDto toDto(UbkBankRequisites requisites);

    public abstract List<UbkBankRequisitesDto> toDtoList(List<UbkBankRequisites> list);


    @AfterMapping
    protected void enrich(@MappingTarget UbkBankRequisitesDto dto, UbkBankRequisites entity) {
        if (entity.getBankId() != null) {
            dto.setBank(referenceMapperService.getBankById(entity.getBankId()));
        }
    }
}