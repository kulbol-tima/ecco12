package kg.mlsp.common.repository;

import kg.mlsp.common.model.RegPerson;
import kg.mlsp.common.model.reference.RefDocumentSerial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface PersonRepository extends JpaRepository<RegPerson, Integer>, JpaSpecificationExecutor<RegPerson> {
    RegPerson findByPinAndIsActive(String pin, Boolean isActive);
    RegPerson findOneByPinAndRefDocumentSerialAndPassportNumber(
            String pin,
            RefDocumentSerial refDocumentSerial,
            String passportNumber
    );

    RegPerson findOneByPersonIdentityId(Integer personIdentityId);
    Iterable<RegPerson> findAllByPinAndIsActive(String pin, Boolean isActive);

}
