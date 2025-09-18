package kg.mlsp.integration.dto.cadastr;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CadastrSearchPinAllResponseDto {
    @JsonProperty("Propcode")
    private String propcode;

    @JsonProperty("Address")
    private String address;

    @JsonProperty("Owner")
    private String owner;

    @JsonProperty("Pin")
    private String pin;

    @JsonProperty("DocNum")
    private String docNum;

    @JsonProperty("REG_DATE")
    private String regDate;

    @JsonProperty("TERM_DATE")
    private String termDate;
}
