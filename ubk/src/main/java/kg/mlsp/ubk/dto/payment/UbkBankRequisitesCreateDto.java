package kg.mlsp.ubk.dto.payment;

import lombok.Data;

@Data
public class UbkBankRequisitesCreateDto {
    private Integer bankId;
    private String accountNumber;
    private Boolean isActive;
}
