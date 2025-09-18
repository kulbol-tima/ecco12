package kg.mlsp.integration.dto.tax;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class TaxTpBusinessActivityByPinResponseDto {
    @JsonProperty("Farm")
    private String farm;

    @JsonProperty("FullName")
    private String fullName;

    @JsonProperty("RayonCode")
    private String rayonCode;

    @JsonProperty("RayonName")
    private String rayonName;

    @JsonProperty("TaxActiveDate")
    private String taxActiveDate;

    @JsonProperty("TaxTypeCode")
    private String taxTypeCode;

    @JsonProperty("TIN")
    private String tin;
}
