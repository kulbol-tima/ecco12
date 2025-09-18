package kg.mlsp.common.controller.reference;

import io.swagger.v3.oas.annotations.tags.Tag;
import kg.mlsp.common.dto.reference.RefBaseFilterDto;
import kg.mlsp.common.model.reference.RefDocumentType;
import kg.mlsp.common.service.reference.RefDocumentTypeServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ref-document-types")
@Tag(name = "Типы документов", description = "Управление справочником типоа документов")
public class RefDocumentTypeController extends BaseRefController<RefDocumentType, Integer, RefBaseFilterDto> {
    public RefDocumentTypeController(RefDocumentTypeServiceImpl service) {
        super(service);
    }
}