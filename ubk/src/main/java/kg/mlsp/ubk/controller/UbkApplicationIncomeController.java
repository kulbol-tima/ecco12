package kg.mlsp.ubk.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import kg.mlsp.ubk.dto.income.UbkApplicationIncomeCreateDto;
import kg.mlsp.ubk.dto.income.UbkApplicationIncomeDto;
import kg.mlsp.ubk.service.UbkApplicationIncomeService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/applications/incomes")
@Tag(name = "Incomes", description = "Incomes management APIs")
public class UbkApplicationIncomeController {

    private final UbkApplicationIncomeService ubkApplicationIncomeService;

    @PostMapping("/create/{applicationId}")
    public ResponseEntity<UbkApplicationIncomeDto> create(@Valid @RequestBody UbkApplicationIncomeCreateDto createDto,
                                                                @PathVariable Integer applicationId) {
        var incomeDto = ubkApplicationIncomeService.create(applicationId, createDto);
        return ResponseEntity.ok(incomeDto);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<UbkApplicationIncomeDto> update(@Valid @RequestBody UbkApplicationIncomeCreateDto updateDto,
                                                                @PathVariable Integer id) {
        var incomeDto = ubkApplicationIncomeService.update(id, updateDto);
        return ResponseEntity.ok(incomeDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UbkApplicationIncomeDto> getById(@PathVariable Integer id) {
        log.info("Fetching application with id: {}", id);
        var incomeDto = ubkApplicationIncomeService.getById(id);
        return ResponseEntity.ok(incomeDto);
    }

    @GetMapping("/list/{applicationId}")
    public ResponseEntity<List<UbkApplicationIncomeDto>> list(@PathVariable Integer applicationId) {
        log.info("Fetching application with id: {}", applicationId);
        var incomeDto = ubkApplicationIncomeService.list(applicationId);
        return ResponseEntity.ok(incomeDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(ubkApplicationIncomeService.delete(id));
    }

}
