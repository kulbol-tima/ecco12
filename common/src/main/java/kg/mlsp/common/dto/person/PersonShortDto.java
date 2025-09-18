package kg.mlsp.common.dto.person;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class PersonShortDto {
    private Integer id;
    private String pin;
    private String surname;
    private String name;
    private String patronymic;
}
