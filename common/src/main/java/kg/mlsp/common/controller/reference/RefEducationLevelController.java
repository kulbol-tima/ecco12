package kg.mlsp.common.controller.reference;

import io.swagger.v3.oas.annotations.tags.Tag;
import kg.mlsp.common.dto.reference.RefBaseFilterDto;
import kg.mlsp.common.model.reference.RefEducationLevel;
import kg.mlsp.common.service.reference.RefEducationLevelServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ref-education-levels")
@Tag(name = "Образования", description = "Управление справочником уровней образования")
public class RefEducationLevelController extends BaseRefController<RefEducationLevel, Integer, RefBaseFilterDto> {
    public RefEducationLevelController(RefEducationLevelServiceImpl service) {
        super(service);
    }
}