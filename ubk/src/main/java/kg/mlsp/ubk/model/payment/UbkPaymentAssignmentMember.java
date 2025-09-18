package kg.mlsp.ubk.model.payment;


import jakarta.persistence.*;
import kg.mlsp.common.model.BaseAuditableEntity;
import kg.mlsp.ubk.model.UbkApplicationFamilyMember;
import lombok.Data;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;

//Назначения на выплату
@Data
@Entity
@Table(name = "ubk_payment_assignment_members")
public class UbkPaymentAssignmentMember extends BaseAuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "family_member_id", referencedColumnName = "id", nullable = false)
    private UbkApplicationFamilyMember familyMember;

    @ManyToOne
    @JoinColumn(name = "assignment_id", referencedColumnName = "id", nullable = false)
    private UbkPaymentAssignment assignment;

    @Column(name = "amount")
    private BigDecimal amount; //Назначенная сумма

    //Районный коэффициент
    @Column(name = "coefficient", nullable = false, precision = 10, scale = 2)
    @ColumnDefault("1.0")
    private BigDecimal coefficient;

    // Коэффициент приграничной зоны
    @Column(name = "border_coefficient", nullable = false, precision = 10, scale = 2)
    @ColumnDefault("1.0")
    private BigDecimal borderCoefficient;

}
