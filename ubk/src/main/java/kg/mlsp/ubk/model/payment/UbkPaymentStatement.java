package kg.mlsp.ubk.model.payment;

import jakarta.persistence.*;
import kg.mlsp.common.model.BaseAuditableEntity;
import kg.mlsp.ubk.model.UbkApplication;
import lombok.Data;


//Ведомость на выплату формируется на основании заявлений каждый месяц

@Data
@Entity
@Table(name = "ubk_payment_statements")
public class UbkPaymentStatement extends BaseAuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "application_id", referencedColumnName = "id", nullable = false)
    private UbkApplication application;

    @ManyToOne
    @JoinColumn(name = "bank_requisites_id", referencedColumnName = "id", nullable = false)
    private UbkBankRequisites bankRequisites;

    @Column(name = "status_id")
    private Integer statusId; // RefStatus

}
