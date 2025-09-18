package kg.mlsp.ubk.dto.familymember;

import kg.mlsp.common.dto.BaseAuditableEntityDto;
import kg.mlsp.common.dto.person.PersonDto;
import kg.mlsp.common.dto.reference.RefGeneralDto;
import lombok.Data;


@Data
public class UbkApplicationFamilyMemberDto extends BaseAuditableEntityDto {
    private Integer id;

    private Integer familyMemberId;
    private PersonDto familyMember;

    private Integer employmentTypeId;
    private RefGeneralDto employmentType;

    private Integer relationshipTypeId;
    private RefGeneralDto relationshipType;

    private Integer personCategoryId;
    private RefGeneralDto personCategory;

    private Integer citizenshipId;
    private RefGeneralDto citizenship;

}
