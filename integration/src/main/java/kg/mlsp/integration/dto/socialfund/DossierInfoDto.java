package kg.mlsp.integration.dto.socialfund;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class DossierInfoDto {
    @JsonProperty("RUSF")
    private String rusf;

    @JsonProperty("NumDossier")
    private String numDossier;

    @JsonProperty("PINPensioner")
    private String pinPensioner;

    @JsonProperty("PINRecipient")
    private String pinRecipient;

    @JsonProperty("DateFromInitial")
    private String dateFromInitial;

    @JsonProperty("DateTo")
    private String dateTo;

    @JsonProperty("KindOfPension")
    private String kindOfPension;

    @JsonProperty("CategoryPension")
    private String categoryPension;

    @JsonProperty("PIN1")
    private String pin1;

    @JsonProperty("PIN2")
    private String pin2;
}


