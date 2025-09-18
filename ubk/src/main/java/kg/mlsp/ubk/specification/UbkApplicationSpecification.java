package kg.mlsp.ubk.specification;


import jakarta.persistence.criteria.Predicate;
import kg.mlsp.ubk.dto.application.UbkApplicationFilterDto;
import kg.mlsp.ubk.model.UbkApplication;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public class UbkApplicationSpecification {

    public static Specification<UbkApplication> filterBy(UbkApplicationFilterDto filter, List<Integer> personIds) {

        return (root, query, cb) -> {
            Predicate predicates = cb.conjunction();

            //Фильтрация по заявлениям
            if (filter.getOrganizationId() != null) {
                predicates = cb.and(predicates, cb.equal(root.get("organizationId"), filter.getOrganizationId()));
            }

            if (filter.getRegistrationNumber() != null && !filter.getRegistrationNumber().isBlank()) {
                predicates = cb.and(predicates, cb.like(cb.lower(root.get("registrationNumber")), "%" + filter.getRegistrationNumber().toLowerCase() + "%"));
            }

            if (filter.getRegistrationDateStart() != null) {
                predicates = cb.and(predicates, cb.greaterThanOrEqualTo(root.get("registrationDate"), filter.getRegistrationDateStart().atStartOfDay()));
            }

            if (filter.getRegistrationDateEnd() != null) {
                predicates = cb.and(predicates, cb.lessThanOrEqualTo(root.get("registrationDate"), filter.getRegistrationDateEnd().atTime(23, 59, 59)));
            }

            if (filter.getRequestTypeId() != null) {
                predicates = cb.and(predicates, cb.equal(root.get("requestTypeId"), filter.getRequestTypeId()));
            }

            if (filter.getStatusId() != null) {
                predicates = cb.and(predicates, cb.equal(root.get("statusId"), filter.getStatusId()));
            }

            //Фильтрация по назначению
            if (filter.getAmount() != null) {
                predicates = cb.and(predicates, cb.equal(root.get("amount"), filter.getAmount()));
            }

            if (filter.getAssignedDateStart() != null) {
                predicates = cb.and(predicates, cb.greaterThanOrEqualTo(root.get("assignedDate"), filter.getAssignedDateStart().atStartOfDay()));
            }

            if (filter.getAssignedDateEnd() != null) {
                predicates = cb.and(predicates, cb.lessThanOrEqualTo(root.get("assignedDate"), filter.getAssignedDateEnd().atTime(23, 59, 59)));
            }

            if (personIds != null && !personIds.isEmpty()) {
                predicates = cb.and(predicates, root.get("applicantId").in(personIds));
            }

            return predicates;
        };
    }
}
