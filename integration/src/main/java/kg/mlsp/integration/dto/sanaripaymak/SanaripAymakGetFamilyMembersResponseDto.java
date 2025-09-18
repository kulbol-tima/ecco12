package kg.mlsp.integration.dto.sanaripaymak;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;


@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class SanaripAymakGetFamilyMembersResponseDto {
    @JsonProperty("code")
    private  String code;

    @JsonProperty("message")
    private  String message;

    @JsonProperty("members")
    private  List<MembersDto> members;

}