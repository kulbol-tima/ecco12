package kg.mlsp.integration.dto.asb;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
public class AddressArrayDto {
    @JsonProperty("countryId")
    private Integer countryId;

    @JsonProperty("regionId")
    private Integer regionId;

    @JsonProperty("districtId")
    private Integer districtId;

    @JsonProperty("aymakId")
    private Integer aymakId;

    @JsonProperty("villageId")
    private Integer villageId;

    @JsonProperty("streetId")
    private Integer streetId;

    @JsonProperty("houseId")
    private Integer houseId;

    @JsonProperty("houseTxt")
    private String houseTxt;

    @JsonProperty("flatId")
    private Integer flatId;

    @JsonProperty("flatTxt")
    private  String flatTxt;

    @JsonProperty("code")
    private String code;

    @JsonProperty("post")
    private String post;
}