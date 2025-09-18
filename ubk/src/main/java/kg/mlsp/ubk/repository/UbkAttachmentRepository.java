package kg.mlsp.ubk.repository;

import kg.mlsp.ubk.model.UbkAttachment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface UbkAttachmentRepository extends JpaRepository<UbkAttachment, Integer> {
    List<UbkAttachment> findByApplicationId(Integer applicationId);
}
