package kg.mlsp.common.controller.reference;

import io.swagger.v3.oas.annotations.tags.Tag;
import kg.mlsp.common.dto.reference.RefBaseFilterDto;
import kg.mlsp.common.model.reference.RefRelationshipType;
import kg.mlsp.common.service.reference.RefRelationshipTypeServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ref-relationship-types")
@Tag(name = "Типы родственных отношений", description = "Управление справочником родственных отношений")
public class RefRelationshipTypeController extends BaseRefController<RefRelationshipType, Integer, RefBaseFilterDto> {
    public RefRelationshipTypeController(RefRelationshipTypeServiceImpl service) {
        super(service);
    }
}