package kg.mlsp.common.dto.person;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class PersonFindDto {

    @NotNull(message = "ПИН не может быть пустым")
    @Length(min = 14, max = 14, message = "ПИН должен состоять из 14 символов")
    private String pin;

    @NotNull(message = "Серия документа не может быть пустым")
    private Integer documentSerialId;

    @NotNull(message = "Номер документа не может быть пустым")
    private String documentNumber;
}
