package kg.mlsp.ubk.model.integration;

import jakarta.persistence.*;
import kg.mlsp.common.model.BaseAuditableEntity;
import kg.mlsp.ubk.model.UbkApplication;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "ubk_data_requests")
public class UbkDataRequest extends BaseAuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "application_d", referencedColumnName = "id", nullable = false)
    private UbkApplication application;

    @Column(name = "request_date", nullable = false)
    private LocalDateTime requestDate; //Дата запроса

    @Column(name = "is_main", nullable = false)
    private Boolean isMain; //Основной, первичный запрос

}
