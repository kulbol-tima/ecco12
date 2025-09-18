package kg.mlsp.common.dto.reference;

import lombok.Data;

@Data
public class RefGeneralDto {
    private Integer id;
    private String nameRu;
    private String nameKy;
    private String code;
    private Boolean isActive;
}
