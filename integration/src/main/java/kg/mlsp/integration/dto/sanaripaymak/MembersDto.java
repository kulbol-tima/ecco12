package kg.mlsp.integration.dto.sanaripaymak;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class MembersDto {
    @JsonProperty("name")
    private String name;
    @JsonProperty("role")
    private String role;
}