package kg.mlsp.ubk.model;

import jakarta.persistence.*;
import kg.mlsp.common.converter.CryptoConverter;
import kg.mlsp.common.model.BaseAuditableEntity;
import lombok.Data;
import org.hibernate.annotations.Where;


//Члены семьи
@Data
@Entity
@Table(name = "ubk_application_family_members")
@Where(clause = "deleted = false")
public class UbkApplicationFamilyMember extends BaseAuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "family_member_id") //Физическое лицо RegPerson id
    private Integer familyMemberId;

    @Column(name = "family_member_pin")
    @Convert(converter = CryptoConverter.class)
    private String familyMemberPin;

    @ManyToOne
    @JoinColumn(name = "application_id", referencedColumnName = "id", nullable = false)
    private UbkApplication application;

    @Column(name = "employment_type_id") //Род занятий RefEmploymentType
    private Integer employmentTypeId;

    @Column(name = "relationship_type_id") //Род отношение RefRelationshipType
    private Integer relationshipTypeId;

    @Column(name = "person_category_id") //Категория лица RefPersonCategoryTye
    private Integer personCategoryId;

    @Column(name = "citizenship_id") //Гражданство RefCountry
    private Integer citizenshipId;

}
