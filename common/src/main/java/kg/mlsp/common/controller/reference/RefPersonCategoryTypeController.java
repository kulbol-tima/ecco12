package kg.mlsp.common.controller.reference;

import io.swagger.v3.oas.annotations.tags.Tag;
import kg.mlsp.common.dto.reference.RefBaseFilterDto;
import kg.mlsp.common.model.reference.RefPersonCategoryType;
import kg.mlsp.common.service.reference.RefPersonCategoryTypeServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ref-person-category-types")
@Tag(name = "Категория заявителя", description = "Управление справочником категорий заявителей")
public class RefPersonCategoryTypeController extends BaseRefController<RefPersonCategoryType, Integer, RefBaseFilterDto> {
    public RefPersonCategoryTypeController(RefPersonCategoryTypeServiceImpl service) {
        super(service);
    }
}