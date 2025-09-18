package kg.mlsp.ubk.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import kg.mlsp.ubk.dto.application.UbkApplicationDto;
import kg.mlsp.ubk.service.UbkApplicationCheckService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/applications")
@Tag(name = "Application", description = "Applications management APIs")
public class UbkApplicationCheckController {
    private final UbkApplicationCheckService ubkApplicationCheckService;

    public UbkApplicationCheckController(UbkApplicationCheckService ubkApplicationCheckService) {
        this.ubkApplicationCheckService = ubkApplicationCheckService;
    }

    @GetMapping("/check-duplicate/{applicationId}")
    public ResponseEntity<UbkApplicationDto> checkDuplicate(@PathVariable Integer applicationId) {
        var duplicateApplication = ubkApplicationCheckService.duplicateCheck(applicationId);

        return ResponseEntity.ok(duplicateApplication);
    }

}
