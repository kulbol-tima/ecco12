package kg.mlsp.integration.dto.passportinfo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Objects;

@Data
public class PassportByPsnResponseDto {

    @JsonProperty("pin")
    public String pin;

    @JsonProperty("surname")
    public String surname;

    @JsonProperty("name")
    public String name;

    @JsonProperty("patronymic")
    public String patronymic;

    @JsonProperty("surnameLatin")
    public String surnameLatin;

    @JsonProperty("nameLatin")
    public String nameLatin;

    @JsonProperty("patronymicLatin")
    public String patronymicLatin;

    @JsonProperty("nationality")
    public String nationality;

    @JsonProperty("dateOfBirth")
    public String dateOfBirth;

    @JsonProperty("placeOfBirth")
    public String passportSeries;

    @JsonProperty("passportNumber")
    public String passportNumber;

    @JsonProperty("authorityCode")
    public String voidStatus;

    @JsonProperty("passportAuthority")
    public String passportAuthority;

    @JsonProperty("issuedDate")
    public String issuedDate;

    @JsonProperty("expiredDate")
    public String expiredDate;

    @JsonProperty("voidMotiv")
    public String voidMotiv;

    @JsonProperty("familyStatus")
    public String familyStatus;

    @JsonProperty("gender")
    public String gender;

    @JsonProperty("addressRegion")
    public String addressRegion;

    @JsonProperty("addressLocality")
    public String addressLocality;

    @JsonProperty("addressStreet")
    public String addressStreet;

    @JsonProperty("addressHouse")
    public String addressHouse;

    @JsonProperty("addressBuilding")
    public String addressBuilding;

    @JsonProperty("addressApartment")
    public String addressApartment;

    @JsonProperty("regionId")
    public Integer regionId;

    @JsonProperty("districtId")
    public Integer districtId;

    @JsonProperty("areaId")
    public Integer areaId;

    @JsonProperty("subareaId")
    public Integer subareaId;

    @JsonProperty("streetId")
    public Integer streetId;

    @JsonProperty("houseId")
    public Integer houseId;

    @JsonIgnore
    public Integer getGenderId()
    {
        return Objects.equals(gender, "M") ? 2 : 1;
    }
}