package kg.mlsp.integration.dto.socialfund;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class WorkPeriodDto {
    @JsonProperty("PIN_LSS")
    private String pinLss;

    @JsonProperty("Payer")
    private String payer;

    @JsonProperty("INN")
    private String inn;

    @JsonProperty("NumSF")
    private String numSf;

    @JsonProperty("DateBegin")
    private String dateBegin;

    @JsonProperty("DateEnd")
    private String dateEnd;
}