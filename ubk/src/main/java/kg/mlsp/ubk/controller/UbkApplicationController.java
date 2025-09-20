package kg.mlsp.ubk.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import kg.mlsp.common.dto.person.PersonDto;
import kg.mlsp.common.dto.person.PersonFindDto;
import kg.mlsp.ubk.dto.application.UbkApplicationCreateDto;
import kg.mlsp.ubk.dto.application.UbkApplicationDto;
import kg.mlsp.ubk.dto.application.UbkApplicationFilterDto;
import kg.mlsp.ubk.dto.application.UbkApplicationListDto;
import kg.mlsp.ubk.service.UbkApplicationService;
import lombok.extern.slf4j.Slf4j;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/applications")
@Tag(name = "Application", description = "Applications management APIs")
public class UbkApplicationController {

    private final UbkApplicationService ubkApplicationService;

    public UbkApplicationController(UbkApplicationService ubkApplicationService) {
        this.ubkApplicationService = ubkApplicationService;
    }

    @GetMapping("list")
    public Page<UbkApplicationListDto> getAll(@ParameterObject UbkApplicationFilterDto filterDto,
                                              @ParameterObject Pageable pageable) {

        return ubkApplicationService.getAll(filterDto, pageable);
    }

    @PostMapping("/find-person")
    public ResponseEntity<PersonDto> findPerson(@RequestBody PersonFindDto personFindDto) {
        var personDto = ubkApplicationService.findPerson(personFindDto);
        return ResponseEntity.ok(personDto);
    }

    @PostMapping("/create")
    public ResponseEntity<UbkApplicationDto> create(@Valid @RequestBody UbkApplicationCreateDto createDto) {
        var applicationDto = ubkApplicationService.create(createDto);
        return ResponseEntity.ok(applicationDto);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<UbkApplicationDto> update(@Valid @RequestBody UbkApplicationCreateDto createDto,
                                                    @PathVariable Integer id) {
        var applicationDto = ubkApplicationService.update(id, createDto);
        return ResponseEntity.ok(applicationDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UbkApplicationDto> getById(@PathVariable Integer id) {
        log.info("Fetching application with id: {}", id);
        var applicationDto = ubkApplicationService.getById(id);
        return ResponseEntity.ok(applicationDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(ubkApplicationService.delete(id));
    }

}
