package kg.mlsp.common.controller.reference;

import io.swagger.v3.oas.annotations.tags.Tag;
import kg.mlsp.common.dto.reference.RefBaseFilterDto;
import kg.mlsp.common.model.reference.RefNationality;
import kg.mlsp.common.service.reference.RefNationalityServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ref-nationalities")
@Tag(name = "Национальность", description = "Управление справочником национальностей")
public class RefNationalityController extends BaseRefController<RefNationality, Integer, RefBaseFilterDto> {
    public RefNationalityController(RefNationalityServiceImpl service) {
        super(service);
    }
}