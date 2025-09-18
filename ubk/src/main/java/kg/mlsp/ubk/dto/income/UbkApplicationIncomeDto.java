package kg.mlsp.ubk.dto.income;

import kg.mlsp.common.dto.person.PersonDto;
import kg.mlsp.common.dto.reference.RefGeneralDto;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class UbkApplicationIncomeDto {

    private Integer id;

    private Integer personId;
    private PersonDto person;

    private Integer incomeTypeId;
    private RefGeneralDto incomeType;

    private Integer employmentTypeId;
    private RefGeneralDto employmentType;

    private BigDecimal amount;
}