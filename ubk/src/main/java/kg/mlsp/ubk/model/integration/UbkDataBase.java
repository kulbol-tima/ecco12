package kg.mlsp.ubk.model.integration;

import jakarta.persistence.*;
import kg.mlsp.common.model.BaseAuditableEntity;
import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@Data
public class UbkDataBase extends BaseAuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "application_d", nullable = false)
    private Integer applicationId;

    @ManyToOne
    @JoinColumn(name = "request_id", referencedColumnName = "id", nullable = false)
    private UbkDataRequest request;

    @Column(name = "request_date", nullable = false)
    private LocalDateTime requestDate; //Дата запроса


}
