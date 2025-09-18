package kg.mlsp.common.service.reference;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.List;

public interface BaseRefService<T, ID, F> {
    List<T> getAll(F filter);

    Page<T> getPaged(F filter, Pageable pageable);

    T getById(ID id);
    T create(T entity);
    T update(ID id, T entity);
    void delete(ID id);
}