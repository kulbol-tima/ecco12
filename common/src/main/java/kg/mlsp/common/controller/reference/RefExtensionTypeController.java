package kg.mlsp.common.controller.reference;

import io.swagger.v3.oas.annotations.tags.Tag;
import kg.mlsp.common.dto.reference.RefBaseFilterDto;
import kg.mlsp.common.model.reference.RefExtensionType;
import kg.mlsp.common.service.reference.RefExtensionTypeServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ref-extension-types")
@Tag(name = "Виды продления", description = "Управление справочником видами продления")
public class RefExtensionTypeController extends BaseRefController<RefExtensionType, Integer, RefBaseFilterDto> {
    public RefExtensionTypeController(RefExtensionTypeServiceImpl service) {
        super(service);
    }
}