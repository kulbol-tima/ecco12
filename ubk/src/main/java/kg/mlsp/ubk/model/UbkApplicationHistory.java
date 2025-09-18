package kg.mlsp.ubk.model;

import jakarta.persistence.*;
import kg.mlsp.common.model.BaseAuditableEntity;
import lombok.Data;

@Data
@Entity
@Table(name = "ubk_application_histories")
public class UbkApplicationHistory extends BaseAuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "application_id", referencedColumnName = "id")
    private UbkApplication application;

    @Column(name = "status_id")
    private Integer statusId;

    @Column(name = "old_status_id")
    private Integer oldStatusId;

    @Column(name = "rejection_reason_id")
    private Integer rejectionReasonId;

    @Column(name = "comment")
    private String comment;

    @Column(name = "ip_address")
    private String ipAddress;

}
