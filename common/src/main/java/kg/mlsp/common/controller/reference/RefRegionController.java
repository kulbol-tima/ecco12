package kg.mlsp.common.controller.reference;

import io.swagger.v3.oas.annotations.tags.Tag;
import kg.mlsp.common.dto.reference.RefBaseFilterDto;
import kg.mlsp.common.model.reference.RefRegion;
import kg.mlsp.common.service.reference.RefRegionServiceImpl;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ref-regions")
@Tag(name = "Регион", description = "Управление справочником регионов (Бишкека, Ош и т.д.)")
public class RefRegionController extends BaseRefController<RefRegion, Integer, RefBaseFilterDto> {
    public RefRegionController(RefRegionServiceImpl service) {
        super(service);
    }
}