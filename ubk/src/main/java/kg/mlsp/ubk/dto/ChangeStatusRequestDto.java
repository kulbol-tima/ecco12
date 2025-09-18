package kg.mlsp.ubk.dto;

import lombok.Data;

@Data
public class ChangeStatusRequestDto {
    private Integer statusId;
    private Integer oldStatusId;
    private Integer rejectionReasonId;
    private String comment;
}
