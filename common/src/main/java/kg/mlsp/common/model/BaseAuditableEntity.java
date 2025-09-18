package kg.mlsp.common.model;

import jakarta.persistence.*;
import lombok.Data;
import org.springframework.data.annotation.*;


import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.util.UUID;
import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public abstract class BaseAuditableEntity {

    @CreatedDate
    @Column(updatable = false, name = "created_date")
    private LocalDateTime createdDate;

    @CreatedBy
    @Column(updatable = false, name = "created_by")
    private UUID createdBy;

    @LastModifiedDate
    @Column(updatable = false, name = "last_modified_date")
    private LocalDateTime lastModifiedDate;

    @LastModifiedBy
    @Column(name = "last_modified_by")
    private UUID lastModifiedBy;

    @Column(name = "deleted")
    private Boolean deleted = false;

    @Column(name = "deleted_date")
    private LocalDateTime deletedDate;

    public void markAsDeleted() {
        this.deleted = true;
        this.deletedDate = LocalDateTime.now();
    }
}