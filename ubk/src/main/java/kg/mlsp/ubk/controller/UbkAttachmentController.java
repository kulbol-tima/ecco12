package kg.mlsp.ubk.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import kg.mlsp.ubk.dto.application.UbkAttachmentCreateDto;
import kg.mlsp.ubk.dto.application.UbkAttachmentDto;
import kg.mlsp.ubk.service.UbkAttachmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/attachments")
@Tag(name = "Attachments", description = "Attachments management APIs")
public class UbkAttachmentController {

    private final UbkAttachmentService ubkAttachmentService;

    @GetMapping("/{applicationId}/list")
    public List<UbkAttachmentDto> list(@PathVariable Integer applicationId) {
        return ubkAttachmentService.list(applicationId);
    }

    @GetMapping("{id}")
    public UbkAttachmentDto getById(@PathVariable Integer id) {
        return ubkAttachmentService.getById(id);
    }

    @PostMapping("/{applicationId}/create")
    public UbkAttachmentDto create(@PathVariable Integer applicationId, @RequestBody UbkAttachmentCreateDto createDto) {
        return ubkAttachmentService.create(applicationId, createDto);
    }

    @PostMapping("/update/{id}")
    public UbkAttachmentDto update(@PathVariable Integer id, @RequestBody UbkAttachmentCreateDto createDto) {
        return ubkAttachmentService.update(id, createDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(ubkAttachmentService.delete(id));
    }

}
