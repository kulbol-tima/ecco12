package kg.mlsp.ubk.controller;


import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/payment-assignments/{applicationId}")
@Tag(name = "Payment assignments", description = "Payment assignment management APIs")
public class UbkPaymentAssignmentController {



}
