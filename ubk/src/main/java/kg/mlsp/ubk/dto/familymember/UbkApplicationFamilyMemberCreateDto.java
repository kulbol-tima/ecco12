package kg.mlsp.ubk.dto.familymember;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
@Data
public class UbkApplicationFamilyMemberCreateDto {
    @NotNull(message = "Член семьи не может быть пустым")
    private Integer personId;
    @NotNull(message = "Род занятий не может быть пустым")
    private Integer employmentTypeId;
    @NotNull(message = "Род.отношение не может быть пустым")
    private Integer relationshipTypeId;
    @NotNull(message = "Категория не может быть пустой")
    private Integer categoryTypeId;

}
