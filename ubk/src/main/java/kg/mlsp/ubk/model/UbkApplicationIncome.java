package kg.mlsp.ubk.model;

import jakarta.persistence.*;
import kg.mlsp.common.converter.CryptoConverter;
import kg.mlsp.common.model.BaseAuditableEntity;
import lombok.Data;
import org.hibernate.annotations.Where;

import java.math.BigDecimal;


//Сведения о доходах
@Data
@Entity
@Table(name = "ubk_application_incomes")
@Where(clause = "deleted = false")
public class UbkApplicationIncome extends BaseAuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "application_id", referencedColumnName = "id", nullable = false)
    private UbkApplication application;

    @Column(name = "person_id")
    private Integer personId; // RegPerson

    @Column(name = "person_pin")
    @Convert(converter = CryptoConverter.class)
    private String personPin;

    @Column(name = "employment_type_id") //Род занятий RefEmploymentType
    private Integer employmentTypeId;

    @Column(name = "income_type_id") //Вид дохода RefIncomeType
    private Integer incomeTypeId;

    @Column(name = "amount", precision = 10, scale = 2)
    private BigDecimal amount;

}
