package kg.mlsp.common.repository.reference;

import kg.mlsp.common.model.reference.BaseRef;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface BaseRefRepository<T extends BaseRef> extends JpaRepository<T, Integer>, JpaSpecificationExecutor<T> {
    T findOneByCode(String code);
}