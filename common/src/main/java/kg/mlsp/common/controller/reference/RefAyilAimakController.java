package kg.mlsp.common.controller.reference;

import io.swagger.v3.oas.annotations.tags.Tag;
import kg.mlsp.common.dto.reference.RefRegionFilterDto;
import kg.mlsp.common.model.reference.RefAyilAimak;
import kg.mlsp.common.model.reference.RefDistrict;
import kg.mlsp.common.service.reference.RefAyilAimakServiceImpl;
import kg.mlsp.common.service.reference.RefDistrictServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ref-ayil-aimak")
@Tag(name = "Айыл аймак", description = "Управление справочником Айыл аймак")
public class RefAyilAimakController extends BaseRefController<RefAyilAimak, Integer, RefRegionFilterDto> {

    private final RefDistrictServiceImpl districtService;

    public RefAyilAimakController(RefAyilAimakServiceImpl service, RefDistrictServiceImpl districtService) {
        super(service);
        this.districtService = districtService;
    }

    @Override
    public RefAyilAimak create(@RequestBody RefAyilAimak ayilAimak) {
        if (ayilAimak.getDistrictId() != null) {
            RefDistrict district = districtService.getById(ayilAimak.getDistrictId());
            ayilAimak.setDistrict(district);
            ayilAimak.setDistrictId(null);
        }
        return service.create(ayilAimak);
    }

    @Override
    @PutMapping("/{id}")
    public RefAyilAimak update(@PathVariable Integer id, @RequestBody RefAyilAimak ayilAimak) {
        if (ayilAimak.getDistrictId() != null) {
            RefDistrict district = districtService.getById(ayilAimak.getDistrictId());
            ayilAimak.setDistrict(district);
            ayilAimak.setDistrictId(null);
        } else {
            ayilAimak.setDistrict(null);
        }

        return service.update(id, ayilAimak);
    }

}