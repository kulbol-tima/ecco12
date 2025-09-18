package kg.mlsp.ubk.service.payment;

import kg.mlsp.ubk.dto.payment.UbkPaymentAssignmentCreateDto;
import kg.mlsp.ubk.model.payment.UbkPaymentAssignment;

public interface UbkPaymentAssignmentService {
    UbkPaymentAssignment create(Integer applicationId, UbkPaymentAssignmentCreateDto createDto);

}
