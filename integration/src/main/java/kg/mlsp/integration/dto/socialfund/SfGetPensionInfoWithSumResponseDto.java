package kg.mlsp.integration.dto.socialfund;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SfGetPensionInfoWithSumResponseDto {

    @JsonProperty("Date")
    private String date;

    @JsonProperty("State")
    private String state;

    @JsonProperty("StateId")
    private Integer stateId;

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

    @JsonProperty("DossierInfos")
    private List<DossierInfoWithSumDto> dossierInfos;

}
