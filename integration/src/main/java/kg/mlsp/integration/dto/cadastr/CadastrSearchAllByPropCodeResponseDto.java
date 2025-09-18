package kg.mlsp.integration.dto.cadastr;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class CadastrSearchAllByPropCodeResponseDto {
    @JsonProperty("materialsten")
    private String materialsten;

    @JsonProperty("Ploshad_stroenia")
    private String ploshadStroenia;

    @JsonProperty("Ploshad_zem_uchastka")
    private String ploshadZemUchastka;

    @JsonProperty("Unit_zem_uchastka")
    private String unitZemUchastka;

    @JsonProperty("God_postroiki")
    private String godPostroiki;

    @JsonProperty("Formasobstvenosti")
    private String formaSobstvenosti;

    @JsonProperty("Naznachenie")
    private String naznachenie;

    @JsonProperty("Formaispolzovania")
    private String formaIspolzovania;

}
