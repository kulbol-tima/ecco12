package kg.mlsp.integration.dto.tax;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaxGetPatentsByPinResponseDto {
    @JsonProperty("id")
    public Integer id;

    @JsonProperty("createdAt")
    public String createdAt;

    @JsonProperty("policyId")
    public Integer policyId;

    @JsonProperty("pin")
    public String pin;

    @JsonProperty("fullName")
    public String fullName;

    @JsonProperty("objectName")
    public String objectName;

    @JsonProperty("objectAddress")
    public String objectAddress;

    @JsonProperty("districts")
    public List<DistrictDto> districts;

    @JsonProperty("gkedCode")
    public String gkedCode;

    @JsonProperty("activityTypes")
    public List<ActivityTypeDto> activityTypes;

    @JsonProperty("dateFrom")
    public String dateFrom;

    @JsonProperty("dateTo")
    public String dateTo;

    @JsonProperty("sum")
    public Integer sum;

    @JsonProperty("statusId")
    public Integer statusId;

    @JsonProperty("status")
    public String status;

    @JsonProperty("statusRu")
    public String statusRu;

    @JsonProperty("pdf")
    public String pdf;
}
