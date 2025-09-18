package kg.mlsp.common.model.reference;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@MappedSuperclass
@Data
public abstract class BaseRef {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "code", unique = true)
    private String code;

    @Column(name = "name_ru")
    private String nameRu;

    @Column(name = "name_ky")
    private String nameKy;

    @Column(name = "is_active")
    @ColumnDefault("true")
    private Boolean isActive;

    @Column(name = "order_number")
    @ColumnDefault("1")
    private Integer orderNumber;

    @CreatedDate
    @Column(updatable = false, name = "created_date")
    private LocalDateTime createdDate;

    @LastModifiedDate
    @Column(updatable = false, name = "last_modified_date")
    private LocalDateTime LastModifiedDate;

}
