package kg.mlsp.ubk.dto.payment;

import lombok.Data;


import java.time.LocalDate;

@Data
public class UbkPaymentAssignmentCreateDto {
    private LocalDate startDate;
    private LocalDate endDate;
}
