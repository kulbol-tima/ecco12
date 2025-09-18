package kg.mlsp.common.dto.person;

import kg.mlsp.common.dto.BaseAuditableEntityDto;
import kg.mlsp.common.dto.reference.RefGeneralDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDate;

@Data
@EqualsAndHashCode(callSuper=false)
public class PersonDto extends BaseAuditableEntityDto {

    private Integer id;
    private String pin;
    private PersonIdentityDto personIdentity;
    private String surname;
    private String name;
    private String patronymic;
    private String nationality;
    private RefGeneralDto refNationality;
    private LocalDate dateOfBirth;
    private String passportSeries;
    private RefGeneralDto refDocumentSerial;
    private String passportNumber;
    private String passportAuthority;
    private LocalDate issuedDate;
    private LocalDate expiredDate;
    private String familyStatus;
    private RefGeneralDto refMaritalStatus;
    private String gender;
    private RefGeneralDto refGender;
    private String addressRegion;
    private String addressLocality;
    private String addressStreet;
    private String addressHouse;
    private String addressBuilding;
    private String addressApartment;

}
