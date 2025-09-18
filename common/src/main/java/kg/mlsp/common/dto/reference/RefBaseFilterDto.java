package kg.mlsp.common.dto.reference;

import lombok.Data;

@Data
public class RefBaseFilterDto {
    private String code;
    private String nameRu;
    private String nameKy;
    private Boolean isActive;
}
