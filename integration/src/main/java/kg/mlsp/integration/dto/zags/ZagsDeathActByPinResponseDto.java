package kg.mlsp.integration.dto.zags;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ZagsDeathActByPinResponseDto {
    @JsonProperty("pin")
    private String pin;

    @JsonProperty("surname")
    private String surname;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("patronymic")
    private String patronymic;

    @JsonProperty("actDate")
    private String actDate;

    @JsonProperty("actNumber")
    private String actNumber;

    @JsonProperty("actGovUnit")
    private String actGovUnit;

    @JsonProperty("docDate")
    private String docDate;

    @JsonProperty("docNumber")
    private String docNumber;

    @JsonProperty("docSeries")
    private String docSeries;

    @JsonProperty("govUnit")
    private String govUnit;

    @JsonProperty("isDuplicate")
    private boolean isDuplicate;

    @JsonProperty("dfrom")
    private String dfrom;

    @JsonProperty("deathTime")
    private String deathTime;
}
