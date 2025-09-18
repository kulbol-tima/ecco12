package kg.mlsp.ubk.repository;

import kg.mlsp.ubk.model.UbkApplicationIncome;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UbkApplicationIncomeRepository extends JpaRepository<UbkApplicationIncome, Integer> {
    List<UbkApplicationIncome> findByApplicationId(Integer applicationId);

}
