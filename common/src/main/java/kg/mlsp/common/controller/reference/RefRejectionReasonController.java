package kg.mlsp.common.controller.reference;

import io.swagger.v3.oas.annotations.tags.Tag;
import kg.mlsp.common.dto.reference.RefBaseFilterDto;
import kg.mlsp.common.model.reference.RefRejectionReason;
import kg.mlsp.common.service.reference.RefRejectionReasonServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ref-rejection-reasons")
@Tag(name = "Причина отказа", description = "Управление справочником причин отказа")
public class RefRejectionReasonController extends BaseRefController<RefRejectionReason, Integer, RefBaseFilterDto> {
    public RefRejectionReasonController(RefRejectionReasonServiceImpl service) {
        super(service);
    }
}