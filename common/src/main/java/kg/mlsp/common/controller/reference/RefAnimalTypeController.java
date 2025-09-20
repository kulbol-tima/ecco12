package kg.mlsp.common.controller.reference;

import io.swagger.v3.oas.annotations.tags.Tag;
import kg.mlsp.common.dto.reference.RefBaseFilterDto;
import kg.mlsp.common.model.reference.RefAnimalType;
import kg.mlsp.common.service.reference.RefAnimalTypeServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ref-animal-types")
@Tag(name = "Тип животных", description = "Справочник Тип животных")
public class RefAnimalTypeController extends BaseRefController<RefAnimalType, Integer, RefBaseFilterDto> {
    public RefAnimalTypeController(RefAnimalTypeServiceImpl service) {
        super(service);
    }
}