package kg.mlsp.common.dto.reference;

import kg.mlsp.common.dto.BaseRefDto;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class RefBankDto extends BaseRefDto {
    private Integer id;
}
