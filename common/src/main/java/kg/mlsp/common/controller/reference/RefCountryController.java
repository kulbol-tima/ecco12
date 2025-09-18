package kg.mlsp.common.controller.reference;

import io.swagger.v3.oas.annotations.tags.Tag;
import kg.mlsp.common.dto.reference.RefBaseFilterDto;
import kg.mlsp.common.model.reference.RefCountry;
import kg.mlsp.common.service.reference.RefCountryServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ref-countries")
@Tag(name = "Страны", description = "Управление справочником стран")
public class RefCountryController extends BaseRefController<RefCountry, Integer, RefBaseFilterDto> {
    public RefCountryController(RefCountryServiceImpl service) {
        super(service);
    }
}