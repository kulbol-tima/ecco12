package kg.mlsp.common.controller.reference;

import io.swagger.v3.oas.annotations.tags.Tag;
import kg.mlsp.common.dto.reference.RefBaseFilterDto;
import kg.mlsp.common.model.reference.RefIncomeType;
import kg.mlsp.common.service.reference.RefIncomeTypeServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ref-income-types")
@Tag(name = "Вид дохода", description = "Управление справочником видов дохода")
public class RefIncomeTypeController extends BaseRefController<RefIncomeType, Integer, RefBaseFilterDto> {
    public RefIncomeTypeController(RefIncomeTypeServiceImpl service) {
        super(service);
    }
}