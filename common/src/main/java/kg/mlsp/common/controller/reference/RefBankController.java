package kg.mlsp.common.controller.reference;

import io.swagger.v3.oas.annotations.tags.Tag;
import kg.mlsp.common.dto.reference.RefBaseFilterDto;
import kg.mlsp.common.model.reference.RefBank;
import kg.mlsp.common.service.reference.RefBankServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ref-banks")
@Tag(name = "Банк", description = "Справочник банков")
public class RefBankController extends BaseRefController<RefBank, Integer, RefBaseFilterDto> {
    public RefBankController(RefBankServiceImpl service) {
        super(service);
    }
}