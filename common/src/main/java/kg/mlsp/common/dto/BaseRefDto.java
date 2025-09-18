package kg.mlsp.common.dto;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;

import java.time.LocalDateTime;

@MappedSuperclass
@Data
public abstract class BaseRefDto {
    private String nameRu;
    private String nameKy;
    private Boolean isActive;
    private Integer orderNumber;
    private LocalDateTime createdDate;
    private LocalDateTime LastModifiedDate;
}
