package kg.mlsp.ubk.mapper;


import kg.mlsp.common.service.PersonMapperService;
import kg.mlsp.common.service.ReferenceMapperService;
import kg.mlsp.ubk.dto.income.UbkApplicationIncomeDto;
import kg.mlsp.ubk.model.UbkApplicationIncome;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring")
public abstract class UbkApplicationIncomeMapper {

    @Autowired
    private ReferenceMapperService referenceMapperService;

    @Autowired
    private PersonMapperService personMapperService;


    public abstract UbkApplicationIncomeDto toDto(UbkApplicationIncome income);
    public abstract List<UbkApplicationIncomeDto> toDtoList(List<UbkApplicationIncome> list);

    @AfterMapping
    protected void enrich(@MappingTarget UbkApplicationIncomeDto dto, UbkApplicationIncome entity) {

        if (entity.getPersonId() != null){
            dto.setPerson(personMapperService.getPerson(entity.getPersonId()));
        }

        if (entity.getEmploymentTypeId() != null) {
            dto.setEmploymentType(referenceMapperService.getEmploymentTypeById(entity.getEmploymentTypeId()));
        }

        if (entity.getIncomeTypeId() != null) {
            dto.setIncomeType(referenceMapperService.getIncomeById(entity.getIncomeTypeId()));
        }
    }
}
