package kg.mlsp.ubk.model;

import jakarta.persistence.*;
import kg.mlsp.common.converter.CryptoConverter;
import kg.mlsp.common.model.BaseAuditableEntity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;


@Data
@Entity
@Table(name = "ubk_applications")
public class UbkApplication extends BaseAuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "organization_id")
    private Integer organizationId; // RefOrganization

    @Column(name = "registration_number")
    private String registrationNumber; //Регистрационный номер

    @Column(name = "registration_date")
    private LocalDate registrationDate; //Дата подачи заявления

    @Column(name = "applicant_id")
    private Integer applicantId; // RegPerson

    @Column(name = "applicant_pin")
    @Convert(converter = CryptoConverter.class)
    private String applicantPin; // RegPerson

    @Column(name = "status_id")
    private Integer statusId; // RefAppStatus

    @Column(name = "request_type_id")
    private Integer requestTypeId; // RefAppRequestType

    @Column(name = "employment_type_id") //Род занятий
    private Integer employmentTypeId; //RefEmploymentType

    @Column(name = "marital_status_id") //Семейное положение
    private Integer maritalStatusId; //RefMaritalStatus

    @Column(name = "person_category_id") //Категория заявителя
    private Integer personCategoryId; //RefPersonCategoryType

    @Column(name = "phone")
    private String phone; //Телефон

    @Column(name = "email")
    private String email; //Электронная почта

    @Column(name = "reason")
    private String reason; //Причина обращения

    @Column(name = "comment")
    private String comment; //Комментарий

    @Column(name = "rejected_reason")
    private String rejectedReason; //Причина отказа

    @Column(name = "attachments_count")
    private Integer attachmentsCount; //Кол-во приложенных документов

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "application")
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<UbkApplicationFamilyMember> familyMembers = new ArrayList<>(); //Члены семьи

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "application") //Сведения о доходах
    @EqualsAndHashCode.Exclude
    @ToString.Exclude
    private List<UbkApplicationIncome> incomes = new ArrayList<>();

    @Column(name = "assigned_date")
    private LocalDateTime assignedDate; //Дата назначения

    @Column(name = "start_date")
    private LocalDate startDate; //Дата начала

    @Column(name = "end_date")
    private LocalDate endDate; //Дата конца

    @Column(name = "amount")
    private BigDecimal amount; //Назначенная сумма


}
