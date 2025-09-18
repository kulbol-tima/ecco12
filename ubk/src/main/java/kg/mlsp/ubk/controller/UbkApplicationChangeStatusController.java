package kg.mlsp.ubk.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import kg.mlsp.ubk.dto.ChangeStatusRequestDto;
import kg.mlsp.ubk.dto.application.UbkApplicationHistoryDto;
import kg.mlsp.ubk.service.UbkApplicationChangeStatusService;
import kg.mlsp.ubk.service.UbkApplicationHistoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/applications")
@Tag(name = "Application", description = "Applications management APIs")
public class UbkApplicationChangeStatusController {

    private final UbkApplicationChangeStatusService ubkApplicationChangeStatusService;
    private final UbkApplicationHistoryService ubkApplicationHistoryService;

    @PostMapping("/change-status/{applicationId}")
    public ResponseEntity<String> changeStatus(@RequestBody ChangeStatusRequestDto changeStatusDto,
                                               @PathVariable Integer applicationId) {
        return ResponseEntity.ok(ubkApplicationChangeStatusService.changeStatus(applicationId, changeStatusDto));
    }

    @GetMapping("/histories/{applicationId}")
    public ResponseEntity<List<UbkApplicationHistoryDto>> histories(@PathVariable Integer applicationId) {
        return ResponseEntity.ok(ubkApplicationHistoryService.list(applicationId));
    }

}
