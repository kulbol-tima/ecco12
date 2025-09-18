package kg.mlsp.common.service.reference;

import jakarta.persistence.criteria.Predicate;
import kg.mlsp.common.dto.reference.RefBaseFilterDto;
import kg.mlsp.common.model.reference.BaseRef;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public abstract class BaseRefServiceImpl<T extends BaseRef, ID, F extends RefBaseFilterDto> implements BaseRefService<T, ID, F> {

    protected final JpaRepository<T, ID> repository;

    protected BaseRefServiceImpl(JpaRepository<T, ID> repository) {
        this.repository = repository;
    }

    protected Specification<T> buildSpecification(F filter) {
        return (root, query, cb) -> {
            Predicate p = cb.conjunction();

            if (filter.getCode() != null && !filter.getCode().isBlank()) {
                p = cb.and(p, cb.like(cb.lower(root.get("code")), "%" + filter.getCode().toLowerCase() + "%"));
            }
            if (filter.getNameRu() != null && !filter.getNameRu().isBlank()) {
                p = cb.and(p, cb.like(cb.lower(root.get("nameRu")), "%" + filter.getNameRu().toLowerCase() + "%"));
            }
            if (filter.getNameKy() != null && !filter.getNameKy().isBlank()) {
                p = cb.and(p, cb.like(cb.lower(root.get("nameKy")), "%" + filter.getNameKy().toLowerCase() + "%"));
            }
            if (filter.getIsActive() != null) {
                p = cb.and(p, cb.equal(root.get("isActive"), filter.getIsActive()));
            }

            return p;
        };
    }


    @Override
    public Page<T> getPaged(F filter, Pageable pageable) {
        if (!(repository instanceof JpaSpecificationExecutor)) {
            throw new UnsupportedOperationException("Filtering not supported.");
        }

        var specRepo = (JpaSpecificationExecutor<T>) repository;
        Specification<T> spec = buildSpecification(filter);

        return specRepo.findAll(spec, pageable);
    }

    @Override
    public List<T> getAll(F filter) {
        if (!(repository instanceof JpaSpecificationExecutor)) {
            throw new UnsupportedOperationException("Filtering not supported.");
        }

        Specification<T> spec = buildSpecification(filter);
        JpaSpecificationExecutor<T> specRepo = (JpaSpecificationExecutor<T>) repository;
        return specRepo.findAll(spec);
    }

    @Override
    public T getById(ID id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Entity not found"));
    }

    @Override
    public T create(T entity) {
        return repository.save(entity);
    }

    @Override
    public T update(ID id, T entity) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Entity not found");
        }
        return repository.save(entity);
    }

    @Override
    public void delete(ID id) {
        repository.deleteById(id);
    }
}