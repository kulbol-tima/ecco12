package kg.mlsp.ubk.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import kg.mlsp.ubk.dto.payment.UbkBankRequisitesCreateDto;
import kg.mlsp.ubk.dto.payment.UbkBankRequisitesDto;
import kg.mlsp.ubk.service.payment.UbkBankRequisitesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/requisites")
@Tag(name = "Bank requisites", description = "Bank requisites management APIs")
public class UbkBankRequisitesController {

    private final UbkBankRequisitesService ubkBankRequisitesService;


    @GetMapping("/{applicationId}/list")
    public List<UbkBankRequisitesDto> list( @PathVariable Integer applicationId) {
        return ubkBankRequisitesService.list(applicationId);
    }

    @GetMapping("/{id}")
    public UbkBankRequisitesDto getById(@PathVariable Integer id) {
        return ubkBankRequisitesService.getById(id);
    }

    @PostMapping("/{applicationId}/create")
    public UbkBankRequisitesDto create(@PathVariable Integer applicationId, @RequestBody UbkBankRequisitesCreateDto createDto) {
        return ubkBankRequisitesService.create(applicationId, createDto);
    }

    @PostMapping("/update/{id}")
    public UbkBankRequisitesDto update(@PathVariable Integer id,
                                       @RequestBody UbkBankRequisitesCreateDto createDto) {
        return ubkBankRequisitesService.update(id, createDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(ubkBankRequisitesService.delete(id));
    }

}
