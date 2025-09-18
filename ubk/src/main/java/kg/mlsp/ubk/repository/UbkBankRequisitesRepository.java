package kg.mlsp.ubk.repository;

import kg.mlsp.ubk.model.payment.UbkBankRequisites;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UbkBankRequisitesRepository extends JpaRepository<UbkBankRequisites, Integer> {
    List<UbkBankRequisites> findByApplicationId(Integer applicationId);
}
