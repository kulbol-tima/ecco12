package kg.mlsp.ubk.repository;

import kg.mlsp.ubk.model.UbkApplicationFamilyMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UbkApplicationFamilyMemberRepository extends JpaRepository<UbkApplicationFamilyMember, Integer> {
    List<UbkApplicationFamilyMember> findByApplicationId(Integer applicationId);

}
