package kg.mlsp.ubk.model.payment;


import jakarta.persistence.*;
import kg.mlsp.common.model.BaseAuditableEntity;
import kg.mlsp.ubk.model.UbkApplication;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

//Назначения на выплату
@Data
@Entity
@Table(name = "ubk_payment_assignments")
public class UbkPaymentAssignment extends BaseAuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "application_id", referencedColumnName = "id", nullable = false)
    private UbkApplication application;

    @Column(name = "assigned_date", nullable = false)
    private LocalDateTime assignedDate; //Дата назначения

    @Column(name = "start_date")
    private LocalDate startDate; //Дата начала

    @Column(name = "end_date")
    private LocalDate endDate; //Дата конца

    @Column(name = "amount")
    private BigDecimal amount; //Назначенная сумма

    @Column(name = "average_income")
    private BigDecimal averageIncome; //Среднедушевой доход

    @Column(name = "family_member_count")
    private Integer familyMemberCount; //Количество членов семьи на дату назначения

    @Column(name = "dependents_count")
    private Integer dependentsCount; // Кол-во иждивенцев

    @Column(name = "under_ward_count")
    private Integer underWardCount; // Кол-во опекаемых

    @Column(name = "twins_count")
    private Integer twinsCount; // Кол-во двойняшек

    @Column(name = "triplets_count")
    private Integer tripletsCount; // Кол-во тройняшек

    @Column(name = "is_active")
    private Boolean isActive;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "assignment", orphanRemoval = true, fetch = FetchType.LAZY)
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<UbkPaymentAssignmentMember> assignmentMembers = new ArrayList<>(); //Члены семьи, на которых назначена выплата

}
