package kg.mlsp.common.dto.person;

import lombok.Data;

@Data
public class PersonIdentityDto {
    private Integer id;
    private String pin;
    private Boolean isDead;
}
