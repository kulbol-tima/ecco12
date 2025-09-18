package kg.mlsp.common.controller.reference;

import io.swagger.v3.oas.annotations.tags.Tag;
import kg.mlsp.common.dto.reference.RefRegionFilterDto;
import kg.mlsp.common.model.reference.RefAyilAimak;
import kg.mlsp.common.model.reference.RefVillage;
import kg.mlsp.common.service.reference.RefAyilAimakServiceImpl;
import kg.mlsp.common.service.reference.RefVillageServiceImpl;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/ref-villages")
@Tag(name = "Айыл, населенный пункт", description = "Управление справочником Айыл, населенный пункт")
public class RefVillageController extends BaseRefController<RefVillage, Integer, RefRegionFilterDto> {

    private final RefAyilAimakServiceImpl ayilAimakService;

    public RefVillageController(RefVillageServiceImpl service, RefAyilAimakServiceImpl ayilAimakService) {
        super(service);
        this.ayilAimakService = ayilAimakService;
    }

    @Override
    public RefVillage create(@RequestBody RefVillage village) {
        if (village.getAyilAimakId() != null) {
            RefAyilAimak ayilAimak = ayilAimakService.getById(village.getAyilAimakId());
            village.setAyilAimak(ayilAimak);
            village.setAyilAimakId(null);
        }
        return service.create(village);
    }

    @Override
    @PutMapping("/{id}")
    public RefVillage update(@PathVariable Integer id, @RequestBody RefVillage village) {
        if (village.getAyilAimakId() != null) {
            RefAyilAimak ayilAimak = ayilAimakService.getById(village.getAyilAimakId());
            village.setAyilAimak(ayilAimak);
            village.setAyilAimakId(null);
        } else {
            village.setAyilAimak(null);
        }

        return service.update(id, village);
    }
}