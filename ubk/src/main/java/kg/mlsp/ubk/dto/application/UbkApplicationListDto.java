package kg.mlsp.ubk.dto.application;

import kg.mlsp.common.dto.person.PersonShortDto;
import kg.mlsp.common.dto.reference.RefGeneralDto;
import lombok.Data;

import java.time.LocalDate;


@Data
public class UbkApplicationListDto {
    private Integer id;
    private String registrationNumber;
    private LocalDate registrationDate;

    private Integer statusId;
    private RefGeneralDto status;

    private Integer requestTypeId;
    private RefGeneralDto requestType;

    private Integer applicantId;
    private PersonShortDto applicant;
}
