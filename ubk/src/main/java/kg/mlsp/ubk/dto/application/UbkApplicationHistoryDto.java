package kg.mlsp.ubk.dto.application;

import kg.mlsp.common.dto.BaseAuditableEntityDto;
import kg.mlsp.common.dto.reference.RefGeneralDto;
import lombok.Data;

@Data
public class UbkApplicationHistoryDto extends BaseAuditableEntityDto {
    private Integer id;

    private Integer statusId;
    private RefGeneralDto status;

    private Integer oldStatusId;
    private RefGeneralDto oldStatus;

    private Integer rejectionReasonId;
    private RefGeneralDto rejectionReason;

    private String comment;
    private String ipAddress;
}
