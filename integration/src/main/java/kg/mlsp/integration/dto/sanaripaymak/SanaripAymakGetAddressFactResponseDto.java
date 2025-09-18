package kg.mlsp.integration.dto.sanaripaymak;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SanaripAymakGetAddressFactResponseDto {
    @JsonProperty("pin")
    private String pin;

    @JsonProperty("liveInHouseholdFrom")
    private Boolean liveInHouseholdFrom;

    @JsonProperty("state")
    private String state;

    @JsonProperty("stateId")
    private Integer stateId;

    @JsonProperty("region")
    private String region;

    @JsonProperty("regionId")
    private Integer regionId;

    @JsonProperty("district")
    private String district;

    @JsonProperty("districtId")
    private Integer districtId;

    @JsonProperty("city")
    private String city;

    @JsonProperty("cityId")
    private Integer cityId;

    @JsonProperty("street")
    private String street;

    @JsonProperty("streetId")
    private Integer streetId;

    @JsonProperty("house")
    private String house;

    @JsonProperty("flat")
    private String flat;

}