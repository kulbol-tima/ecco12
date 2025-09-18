package kg.mlsp.ubk.model.payment;

import jakarta.persistence.*;
import kg.mlsp.common.model.BaseAuditableEntity;
import kg.mlsp.ubk.model.UbkApplication;
import lombok.Data;
import org.hibernate.annotations.Where;


//Банковские реквизиты
@Data
@Entity
@Table(name = "ubk_bank_requisites")
@Where(clause = "deleted = false")
public class UbkBankRequisites extends BaseAuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "application_id", referencedColumnName = "id", nullable = false)
    private UbkApplication application;

    @Column(name = "bank_id")
    private Integer bankId; // RefBank

    @Column(name = "account_number", nullable = false, unique = true) //Расчетный cчет
    private String accountNumber;

    @Column(name = "is_active")
    private Boolean isActive = true; //Активен ли реквизит

}