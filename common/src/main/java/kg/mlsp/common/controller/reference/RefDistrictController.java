package kg.mlsp.common.controller.reference;

import io.swagger.v3.oas.annotations.tags.Tag;
import kg.mlsp.common.dto.reference.RefRegionFilterDto;
import kg.mlsp.common.model.reference.RefDistrict;
import kg.mlsp.common.model.reference.RefRegion;
import kg.mlsp.common.service.reference.RefDistrictServiceImpl;
import kg.mlsp.common.service.reference.RefRegionServiceImpl;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ref-districts")
@Tag(name = "Районы", description = "Управление районами")
public class RefDistrictController extends BaseRefController<RefDistrict, Integer, RefRegionFilterDto> {

    private final RefRegionServiceImpl regionService;

    public RefDistrictController(RefDistrictServiceImpl service, RefRegionServiceImpl regionService) {
        super(service);
        this.regionService = regionService;
    }

    @Override
    public RefDistrict create(@RequestBody RefDistrict district) {
        if (district.getRegionId() != null) {
            RefRegion region = regionService.getById(district.getRegionId());
            district.setRegion(region);
            district.setRegionId(null);
        }
        return service.create(district);
    }

    @Override
    @PutMapping("/{id}")
    public RefDistrict update(@PathVariable Integer id, @RequestBody RefDistrict district) {
        if (district.getRegionId() != null) {
            RefRegion region = regionService.getById(district.getRegionId());
            district.setRegion(region);
            district.setRegionId(null);
        } else {
            district.setRegion(null);
        }

        return service.update(id, district);
    }

}