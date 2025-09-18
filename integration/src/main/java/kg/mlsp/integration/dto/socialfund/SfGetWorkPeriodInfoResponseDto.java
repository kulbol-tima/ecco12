package kg.mlsp.integration.dto.socialfund;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SfGetWorkPeriodInfoResponseDto {

    @JsonProperty("State")
    private String state;

    @JsonProperty("PIN")
    private String pin;

    @JsonProperty("FirstName")
    private String firstName;

    @JsonProperty("LastName")
    private String lastName;

    @JsonProperty("Patronymic")
    private String patronymic;

    @JsonProperty("Issuer")
    private String issuer;

    @JsonProperty("WorkPeriods")
    private List<WorkPeriodDto> workPeriods;

}
