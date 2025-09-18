package kg.mlsp.common.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import kg.mlsp.common.converter.CryptoConverter;
import kg.mlsp.common.model.reference.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

//Реестр физических лиц
@Data
@Entity
@Table(name = "reg_persons")
@EqualsAndHashCode(callSuper=false)
public class RegPerson extends BaseAuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "person_identity_id", referencedColumnName = "id")
    private RegPersonIdentity personIdentity;

    @Column(name = "pin", nullable = false)
    @Convert(converter = CryptoConverter.class)
    private String pin;

    @Column(name = "surname", nullable = false)
    @Convert(converter = CryptoConverter.class) // Фамилия
    private String surname;

    @Column(name = "name", nullable = false)
    @Convert(converter = CryptoConverter.class) // Имя
    private String name;

    @Column(name = "patronymic")
    @Convert(converter = CryptoConverter.class) // Отчество
    private String patronymic;

    @Column(name = "nationality")
    private String nationality;

    @ManyToOne
    @JoinColumn(name = "ref_nationality_id", referencedColumnName = "id")
    private RefNationality refNationality;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column(name = "passport_series")
    private String passportSeries;

    @ManyToOne
    @JoinColumn(name = "ref_document_serial_id", referencedColumnName = "id")
    private RefDocumentSerial refDocumentSerial;

    @Column(name = "passport_number")
    @Convert(converter = CryptoConverter.class)
    private String passportNumber;

    @Column(name = "passport_authority")
    @Convert(converter = CryptoConverter.class)
    private String passportAuthority;

    @Column(name = "issued_date")
    private LocalDate issuedDate;

    @Column(name = "expired_date")
    private LocalDate expiredDate;

    @Column(name = "family_status")
    @Convert(converter = CryptoConverter.class)
    private String familyStatus;

    @ManyToOne
    @JoinColumn(name = "ref_marital_status_id", referencedColumnName = "id")
    private RefMaritalStatus refMaritalStatus;

    @Column(name = "gender")
    private String gender;

    @ManyToOne
    @JoinColumn(name = "ref_gender_id", referencedColumnName = "id")
    private RefGender refGender;

    @Column(name = "address_region")
    @Convert(converter = CryptoConverter.class)
    private String addressRegion;

    @Column(name = "address_locality")
    @Convert(converter = CryptoConverter.class)
    private String addressLocality;

    @Column(name = "address_street")
    @Convert(converter = CryptoConverter.class)
    private String addressStreet;

    @Column(name = "address_house")
    @Convert(converter = CryptoConverter.class)
    private String addressHouse;

    @Column(name = "address_building")
    @Convert(converter = CryptoConverter.class)
    private String addressBuilding;

    @Column(name = "address_apartment")
    @Convert(converter = CryptoConverter.class)
    private String addressApartment;

    @Column(name = "region_id")
    private Integer regionId;

    @Column(name = "district_id")
    private Integer districtId;

    @Column(name = "area_id")
    private Integer areaId;

    @Column(name = "subarea_id")
    private Integer subareaId;

    @Column(name = "street_id")
    private Integer streetId;

    @Column(name = "house_id")
    private Integer houseId;

    @JsonProperty("death_date")
    public LocalDate deathDate;

    @Column(name = "is_active")
    private Boolean isActive = true;

    @Column(name = "is_passport_data")
    private Boolean isPassportData;


    public Integer getAge() {
        if (dateOfBirth == null) {
            return null;
        }
        return LocalDate.now().getYear() - dateOfBirth.getYear();
    }

}
