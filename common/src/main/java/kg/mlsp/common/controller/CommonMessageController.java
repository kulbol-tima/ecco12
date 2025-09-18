package kg.mlsp.common.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import kg.mlsp.common.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
@RequiredArgsConstructor
@RequestMapping("/messages")
@Tag(name = "Messages", description = "Common Messages")
public class CommonMessageController {

    private final MessageService messageService;


    @GetMapping("error-messages")
    public ResponseEntity<Map<String, String>> errorMessages() {
        return ResponseEntity.ok(messageService.getErrorMessages());
    }

    @GetMapping("success-messages")
    public ResponseEntity<Map<String, String>> successMessages() {
        return ResponseEntity.ok(messageService.getSuccessMessages());
    }

}
