package kg.mlsp.common.controller.reference;

import io.swagger.v3.oas.annotations.tags.Tag;
import kg.mlsp.common.dto.reference.RefBaseFilterDto;
import kg.mlsp.common.model.reference.RefOrganization;
import kg.mlsp.common.service.reference.RefOrganizationServiceImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ref-organizations")
@Tag(name = "Организации", description = "Управление справочником организаций")
public class RefOrganizationController extends BaseRefController<RefOrganization, Integer, RefBaseFilterDto> {
    public RefOrganizationController(RefOrganizationServiceImpl service) {
        super(service);
    }

    @GetMapping("/sync")
    public ResponseEntity<String> Sync() {
        return ResponseEntity.ok("Synchronization started");
    }

}