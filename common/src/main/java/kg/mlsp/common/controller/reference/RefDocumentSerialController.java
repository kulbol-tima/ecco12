package kg.mlsp.common.controller.reference;

import io.swagger.v3.oas.annotations.tags.Tag;
import kg.mlsp.common.dto.reference.RefBaseFilterDto;
import kg.mlsp.common.model.reference.RefDocumentSerial;
import kg.mlsp.common.service.reference.RefDocumentSerialServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ref-document-serials")
@Tag(name = "Серия документов", description = "Справочник серий документов (AN, ID, ...)")
public class RefDocumentSerialController extends BaseRefController<RefDocumentSerial, Integer, RefBaseFilterDto> {
    public RefDocumentSerialController(RefDocumentSerialServiceImpl service) {
        super(service);
    }
}