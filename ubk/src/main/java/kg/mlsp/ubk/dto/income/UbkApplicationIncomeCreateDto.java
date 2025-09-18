package kg.mlsp.ubk.dto.income;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class UbkApplicationIncomeCreateDto {

    @NotNull(message = "Физ. лицо не может быть пустым")
    private Integer personId;

    @NotNull(message = "Вид дохода не может быть пустым")
    private Integer incomeTypeId;

    @NotNull(message = "Сумма дохода не может быть пустой")
    private BigDecimal amount;

    private Integer employmentTypeId;

}
