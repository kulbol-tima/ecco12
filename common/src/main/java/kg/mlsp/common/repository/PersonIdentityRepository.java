package kg.mlsp.common.repository;

import kg.mlsp.common.model.RegPersonIdentity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonIdentityRepository extends JpaRepository<RegPersonIdentity, Integer> {
    RegPersonIdentity findOneByPin(String pin);
}
