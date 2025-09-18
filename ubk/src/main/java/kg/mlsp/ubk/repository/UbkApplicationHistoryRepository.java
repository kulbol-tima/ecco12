package kg.mlsp.ubk.repository;

import kg.mlsp.ubk.model.UbkApplicationHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UbkApplicationHistoryRepository extends JpaRepository<UbkApplicationHistory, Integer> {
    List<UbkApplicationHistory> findByApplicationIdOrderByCreatedDateDesc(Integer applicationId);
}
