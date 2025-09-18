package kg.mlsp.ubk.repository;

import kg.mlsp.ubk.model.payment.UbkPaymentAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UbkPaymentAssignmentRepository extends JpaRepository<UbkPaymentAssignment, Integer> {
    UbkPaymentAssignment findByApplicationId(Integer applicationId);

}

