package kg.mlsp.common.specification;

import jakarta.persistence.criteria.Predicate;
import kg.mlsp.common.dto.person.PersonFilterDto;
import kg.mlsp.common.model.RegPerson;
import org.springframework.data.jpa.domain.Specification;

public class RegPersonSpecification {

    public static Specification<RegPerson> filterBy(PersonFilterDto filter) {

        return (root, query, cb) -> {
            Predicate predicates = cb.conjunction();

            if (filter.getId() != null) {
                predicates = cb.and(predicates, cb.equal(root.get("id"), filter.getId()));
            }
            if (filter.getPin() != null && !filter.getPin().isBlank()) {
                predicates = cb.and(predicates, cb.equal(root.get("pin"), filter.getPin()));
            }
            if (filter.getFirstName() != null && !filter.getFirstName().isBlank()) {
                predicates = cb.and(predicates, cb.like(cb.lower(root.get("firstName")), "%" + filter.getFirstName().toLowerCase() + "%"));
            }
            if (filter.getSecondName() != null && !filter.getSecondName().isBlank()) {
                predicates = cb.and(predicates, cb.like(cb.lower(root.get("secondName")), "%" + filter.getSecondName().toLowerCase() + "%"));
            }
            if (filter.getMiddleName() != null && !filter.getMiddleName().isBlank()) {
                predicates = cb.and(predicates, cb.like(cb.lower(root.get("middleName")), "%" + filter.getMiddleName().toLowerCase() + "%"));
            }
            if (filter.getBirthday() != null) {
                predicates = cb.and(predicates, cb.equal(root.get("birthday"), filter.getBirthday()));
            }
            if (filter.getGenderId() != null) {
                predicates = cb.and(predicates, cb.equal(root.get("gender").get("id"), filter.getGenderId()));
            }
            if (filter.getNationalityId() !=null){
                predicates = cb.and(predicates, cb.equal(root.get("nationality").get("id"), filter.getNationalityId()));
            }
            if (filter.getMaritalStatusId() != null) {
                predicates = cb.and(predicates, cb.equal(root.get("maritalStatus").get("id"), filter.getMaritalStatusId()));
            }
            if (filter.getDocumentTypeId() != null) {
                predicates = cb.and(predicates, cb.equal(root.get("documentType").get("id"), filter.getDocumentTypeId()));
            }
            if (filter.getDocumentSerialId() != null) {
                predicates = cb.and(predicates, cb.equal(root.get("documentSerial").get("id"), filter.getDocumentSerialId()));
            }
            if (filter.getDocumentNumber() != null && !filter.getDocumentNumber().isBlank()) {
                predicates = cb.and(predicates, cb.equal(root.get("documentNumber"), filter.getDocumentNumber()));
            }
            if (filter.getDocumentIssued() != null && !filter.getDocumentIssued().isBlank()) {
                predicates = cb.and(predicates, cb.like(cb.lower(root.get("documentIssued")), "%" + filter.getDocumentIssued().toLowerCase() + "%"));
            }
            if (filter.getDocumentDateOfIssue() != null) {
                predicates = cb.and(predicates, cb.equal(root.get("documentDateOfIssue"), filter.getDocumentDateOfIssue()));
            }
            if (filter.getCitizenshipId() != null) {
                predicates = cb.and(predicates, cb.equal(root.get("citizenship").get("id"), filter.getCitizenshipId()));
            }
            if (filter.getRegionId() != null) {
                predicates = cb.and(predicates, cb.equal(root.get("region").get("id"), filter.getRegionId()));
            }
            if (filter.getDistrict() != null && !filter.getDistrict().isBlank()) {
                predicates = cb.and(predicates, cb.like(cb.lower(root.get("district")), "%" + filter.getDistrict().toLowerCase() + "%"));
            }
            if (filter.getCity() != null && !filter.getCity().isBlank()) {
                predicates = cb.and(predicates, cb.like(cb.lower(root.get("city")), "%" + filter.getCity().toLowerCase() + "%"));
            }
            if (filter.getAddress() != null && !filter.getAddress().isBlank()) {
                predicates = cb.and(predicates, cb.like(cb.lower(root.get("address")), "%" + filter.getAddress().toLowerCase() + "%"));
            }

            return predicates;
        };
    }
}