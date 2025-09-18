package kg.mlsp.ubk.dto.application;

import kg.mlsp.common.dto.BaseAuditableEntityDto;
import kg.mlsp.common.dto.person.PersonDto;
import kg.mlsp.common.dto.reference.RefGeneralDto;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UbkApplicationDto extends BaseAuditableEntityDto {

    private Integer id;
    private String registrationNumber;
    private LocalDate registrationDate;

    private Integer organizationId;
    private RefGeneralDto organization;

    private Integer statusId;
    private RefGeneralDto status;

    private Integer requestTypeId;
    private RefGeneralDto requestType;

    private Integer applicantId;
    private PersonDto applicant;

    private Integer employmentTypeId;
    private RefGeneralDto employmentType;

    private Integer maritalStatusId;
    private RefGeneralDto maritalStatus;


    private Integer personCategoryId;
    private RefGeneralDto personCategory;

    private String phone;
    private String email;
    private String reason;
    private String comment;
    private Integer attachmentsCount;
}
