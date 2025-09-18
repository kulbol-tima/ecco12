package kg.mlsp.common.dto.person;

import lombok.Data;

import java.time.LocalDate;

@Data
public class PersonFilterDto {
    private Integer id;
    private String pin;
    private String firstName;
    private String secondName;
    private String middleName;
    private LocalDate birthday;
    private Integer genderId;
    private Integer nationalityId;
    private Integer maritalStatusId;
    private Integer documentTypeId;
    private Integer documentSerialId;
    private String documentNumber;
    private String documentIssued;
    private LocalDate documentDateOfIssue;
    private Integer citizenshipId;
    private Integer regionId;
    private String district;
    private String city;
    private String address;


    public boolean isEmpty() {
        return id == null &&
                (pin == null || pin.isBlank()) &&
                (firstName == null || firstName.isBlank()) &&
                (secondName == null || secondName.isBlank()) &&
                (middleName == null || middleName.isBlank()) &&
                (birthday == null) &&
                (genderId == null) &&
                (nationalityId == null) &&
                (maritalStatusId == null) &&
                (documentTypeId == null) &&
                (documentSerialId == null) &&
                (documentNumber == null || documentNumber.isBlank()) &&
                (documentIssued == null || documentIssued.isBlank()) &&
                (documentDateOfIssue == null) &&
                (citizenshipId == null) &&
                (regionId == null) &&
                (district == null || district.isBlank()) &&
                (city == null || city.isBlank()) &&
                (address == null || address.isBlank());

    }
}
