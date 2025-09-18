package kg.mlsp.common.controller.reference;

import io.swagger.v3.oas.annotations.tags.Tag;
import kg.mlsp.common.dto.reference.RefBaseFilterDto;
import kg.mlsp.common.model.reference.RefMaritalStatus;
import kg.mlsp.common.service.reference.RefMaritalStatusServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ref-marital-statuses")
@Tag(name = "Семейное положение", description = "Управление справочником семейного положения")
public class RefMaritalStatusController extends BaseRefController<RefMaritalStatus, Integer, RefBaseFilterDto> {
    public RefMaritalStatusController(RefMaritalStatusServiceImpl service) {
        super(service);
    }
}