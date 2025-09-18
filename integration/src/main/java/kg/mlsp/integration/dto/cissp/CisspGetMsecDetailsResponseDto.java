package kg.mlsp.integration.dto.cissp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CisspGetMsecDetailsResponseDto {
    @JsonProperty("deathPeriod")
    private boolean deathPeriod;

    @JsonProperty("OrganizationName")
    private String organizationName;

    @JsonProperty("ExaminationDate")
    private String examinationDate;

    @JsonProperty("ExaminationType")
    private String examinationType;

    @JsonProperty("DisabilityGroup")
    private String disabilityGroup;

    @JsonProperty("From")
    private String from;

    @JsonProperty("To")
    private String to;

    @JsonProperty("TimeOfDisability")
    private String timeOfDisability;

    @JsonProperty("ReExamination")
    private String reExamination;

    @JsonProperty("StatusCode")
    private String statusCode;

    @JsonProperty("ErrorMessage")
    private String errorMessage;

    @JsonProperty("InAbsentia")
    private boolean inAbsentia;

    @JsonProperty("IsDeathPeriod")
    private boolean isDeathPeriod;

    @JsonProperty("WheelchairGoal")
    private boolean wheelchairGoal;

    @JsonProperty("HasIPR")
    private boolean hasIPR;
}