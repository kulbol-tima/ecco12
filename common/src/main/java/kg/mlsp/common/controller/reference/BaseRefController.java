package kg.mlsp.common.controller.reference;

import kg.mlsp.common.service.reference.BaseRefService;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;


import java.util.List;

public abstract class BaseRefController<T, ID, F> {

    protected final BaseRefService<T, ID, F> service;

    protected BaseRefController(BaseRefService<T, ID, F> service) {
        this.service = service;
    }

    @GetMapping("/all")
    public List<T> getAll(@ParameterObject F filter) {
        return service.getAll(filter);
    }

    @GetMapping("/paged")
    public Page<T> getPaged(@ParameterObject F filter, @ParameterObject Pageable pageable) {
        return service.getPaged(filter, pageable);
    }

    @GetMapping("/{id}")
    public T get(@PathVariable ID id) {
        return service.getById(id);
    }

    @PostMapping
    public T create(@RequestBody T entity) {
        return service.create(entity);
    }

    @PutMapping("/{id}")
    public T update(@PathVariable ID id, @RequestBody T entity) {
        return service.update(id, entity);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable ID id) {
        service.delete(id);
    }
}