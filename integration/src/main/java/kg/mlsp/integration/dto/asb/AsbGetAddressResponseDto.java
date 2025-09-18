package kg.mlsp.integration.dto.asb;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class AsbGetAddressResponseDto {
    @JsonProperty("error")
    private Boolean error;

    @JsonProperty("address")
    private String address;

    @JsonProperty("dateAction")
    private String dateAction;

    @JsonProperty("dateCreated")
    private String dateCreated;


    @JsonProperty("addressArray")
    private List<AddressArrayDto> addressArray;

}