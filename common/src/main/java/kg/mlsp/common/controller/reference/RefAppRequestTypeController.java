package kg.mlsp.common.controller.reference;

import io.swagger.v3.oas.annotations.tags.Tag;
import kg.mlsp.common.dto.reference.RefBaseFilterDto;
import kg.mlsp.common.model.reference.RefAppRequestType;
import kg.mlsp.common.service.reference.RefAppRequestTypeServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ref-app-request-types")
@Tag(name = "Тип заявления", description = "Управление типами заявлений. (Первичное, повторное)")
public class RefAppRequestTypeController extends BaseRefController<RefAppRequestType, Integer, RefBaseFilterDto> {
    public RefAppRequestTypeController(RefAppRequestTypeServiceImpl service) {
        super(service);
    }
}