package kg.mlsp.integration.dto.tax;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ActivityTypeDto {
    @JsonProperty("finalElement")
    public boolean finalElement;
    @JsonProperty("id")
    public Integer id;
    @JsonProperty("createdAt")
    public Integer createdAt;
    @JsonProperty("name")
    public String name;
    @JsonProperty("parentId")
    public Integer parentId;
    @JsonProperty("isFinalElement")
    public boolean isFinalElement;
}

