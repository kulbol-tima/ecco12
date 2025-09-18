package kg.mlsp.common.dto.reference;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class RefRegionFilterDto extends RefBaseFilterDto {
    private Integer regionId;
    private Integer districtId;
    private Integer ayilAimakId;
}
