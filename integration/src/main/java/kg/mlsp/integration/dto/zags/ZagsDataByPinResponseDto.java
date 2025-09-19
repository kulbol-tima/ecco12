package kg.mlsp.integration.dto.zags;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Objects;

@Data
public class ZagsDataByPinResponseDto {
    @JsonProperty("pin")
    public String pin;

    @JsonProperty("name")
    public String name;

    @JsonProperty("surname")
    public String surname;

    @JsonProperty("patronymic")
    public String patronymic;

    @JsonProperty("gender")
    public String gender;

    @JsonProperty("maritalStatus")
    public String maritalStatus;

    @JsonProperty("maritalStatusId")
    public Integer maritalStatusId;

    @JsonProperty("nationality")
    public String nationality;

    @JsonProperty("nationalityId")
    public Integer nationalityId;

    @JsonProperty("citizenship")
    public String citizenship;

    @JsonProperty("citizenshipId")
    public Integer citizenshipId;

    @JsonProperty("pinBlocked")
    public Boolean pinBlocked;

    @JsonProperty("pinGenerationDate")
    public String pinGenerationDate;

    @JsonProperty("dateOfBirth")
    public String dateOfBirth;

    @JsonProperty("deathDate")
    public String deathDate;

    @JsonProperty("faultcode")
    public String faultcode;

    @JsonProperty("faultstring")
    public String faultstring;


    @JsonIgnore
    public Integer getGenderId()
    {
        return Objects.equals(gender, "1") ? 1 : 2;
    }

    @JsonIgnore
    public String getGenderCode()
    {
        return Objects.equals(gender, "1") ? "F" : "M";
    }

    @JsonIgnore
    public String getMaritalStatusCode()
    {
        switch (maritalStatusId) {
            case 0:
                return "SINGLE"; //Не замужем/женат
            case 1:
                return "MARRIED"; //Замужем/женат
            case 2:
                return "DIVORCED"; //Разведен(а)
            case 3:
                return "WIDOWED"; //Вдова/вдовец
            default:
                return "UNKNOWN"; //Не указано
        }
    }
}