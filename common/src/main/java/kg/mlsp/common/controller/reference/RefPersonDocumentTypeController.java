package kg.mlsp.common.controller.reference;

import io.swagger.v3.oas.annotations.tags.Tag;
import kg.mlsp.common.dto.reference.RefBaseFilterDto;
import kg.mlsp.common.model.reference.RefPersonDocumentType;
import kg.mlsp.common.service.reference.RefPersonDocumentTypeServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ref-person-document-types")
@Tag(name = "Типы удостоверений личности", description = "Управление справочником типов удостоверений личности (паспорт, ID-карта и т.д.)")
public class RefPersonDocumentTypeController extends BaseRefController<RefPersonDocumentType, Integer, RefBaseFilterDto> {
    public RefPersonDocumentTypeController(RefPersonDocumentTypeServiceImpl service) {
        super(service);
    }
}