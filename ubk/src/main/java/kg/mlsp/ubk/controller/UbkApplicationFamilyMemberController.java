package kg.mlsp.ubk.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import kg.mlsp.ubk.dto.familymember.UbkApplicationFamilyMemberCreateDto;
import kg.mlsp.ubk.dto.familymember.UbkApplicationFamilyMemberDto;
import kg.mlsp.ubk.service.UbkApplicationFamilyMemberService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/applications/family-members")
@Tag(name = "Family members", description = "Family members applications management APIs")
public class UbkApplicationFamilyMemberController {

    private final UbkApplicationFamilyMemberService ubkApplicationFamilyMemberService;

    @PostMapping("/create/{applicationId}")
    public ResponseEntity<UbkApplicationFamilyMemberDto> create(@Valid @RequestBody UbkApplicationFamilyMemberCreateDto createDto,
                                                                @PathVariable Integer applicationId) {
        var memberDto = ubkApplicationFamilyMemberService.create(applicationId, createDto);
        return ResponseEntity.ok(memberDto);
    }

    @PostMapping("/update/{id}")
    public ResponseEntity<UbkApplicationFamilyMemberDto> update(@Valid @RequestBody UbkApplicationFamilyMemberCreateDto updateDto,
                                                                @PathVariable Integer id) {
        var memberDto = ubkApplicationFamilyMemberService.update(id, updateDto);
        return ResponseEntity.ok(memberDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UbkApplicationFamilyMemberDto> getById(@PathVariable Integer id) {
        var memberDto = ubkApplicationFamilyMemberService.getById(id);
        return ResponseEntity.ok(memberDto);
    }

    @GetMapping("/list/{applicationId}")
    public ResponseEntity<List<UbkApplicationFamilyMemberDto>> list(@PathVariable Integer applicationId) {
        var memberDto = ubkApplicationFamilyMemberService.list(applicationId);
        return ResponseEntity.ok(memberDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Integer id) {
        return ResponseEntity.ok(ubkApplicationFamilyMemberService.delete(id));
    }

}
