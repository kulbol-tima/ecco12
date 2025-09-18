package kg.mlsp.ubk.dto.payment;

import kg.mlsp.common.dto.reference.RefGeneralDto;
import lombok.Data;

@Data
public class UbkBankRequisitesDto {
    private Integer id;
    private Integer bankId;
    private RefGeneralDto bank;
    private String accountNumber;
    private Boolean isActive;
}
