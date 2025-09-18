package kg.mlsp.common.controller.reference;

import io.swagger.v3.oas.annotations.tags.Tag;
import kg.mlsp.common.dto.reference.RefBaseFilterDto;
import kg.mlsp.common.model.reference.RefEmploymentType;
import kg.mlsp.common.service.reference.RefEmploymentTypeServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ref-employment-types")
@Tag(name = "Занятие", description = "Род занятий заявителя")
public class RefEmploymentTypeController extends BaseRefController<RefEmploymentType, Integer, RefBaseFilterDto> {
    public RefEmploymentTypeController(RefEmploymentTypeServiceImpl service) {
        super(service);
    }
}