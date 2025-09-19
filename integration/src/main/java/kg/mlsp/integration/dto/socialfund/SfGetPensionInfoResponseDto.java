package kg.mlsp.integration.dto.socialfund;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SfGetPensionInfoResponseDto {

    @JsonProperty("Date")
    private String date;

    @JsonProperty("State")
    private String state;

    @JsonProperty("PIN")
    private String pin;

    @JsonProperty("LastName")
    private String lastName;

    @JsonProperty("FirstName")
    private String firstName;

    @JsonProperty("FullName")
    private String fullName;

    @JsonProperty("Issuer")
    private String issuer;

    @JsonProperty("DossierInfoes")
    private List<DossierInfoDto> dossierInfoes;

}
