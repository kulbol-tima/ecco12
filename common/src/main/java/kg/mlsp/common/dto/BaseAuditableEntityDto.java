package kg.mlsp.common.dto;

import jakarta.persistence.MappedSuperclass;
import lombok.Data;
import java.time.LocalDateTime;
import java.util.UUID;

@MappedSuperclass
@Data
public abstract class BaseAuditableEntityDto {
    private LocalDateTime createdDate;
    private UUID createdBy;
    private LocalDateTime lastModifiedDate;
    private UUID lastModifiedBy;
    private Boolean deleted;
    private LocalDateTime deletedDate;

}