package kg.mlsp.common.service.reference;

import kg.mlsp.common.dto.reference.RefRegionFilterDto;
import kg.mlsp.common.model.reference.RefVillage;
import kg.mlsp.common.repository.reference.RefVillageRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class RefVillageServiceImpl extends BaseRefServiceImpl<RefVillage, Integer, RefRegionFilterDto> {
    public RefVillageServiceImpl(RefVillageRepository repository) {
        super(repository);
    }

    @Override
    protected Specification<RefVillage> buildSpecification(RefRegionFilterDto filter) {
        Specification<RefVillage> baseSpec = super.buildSpecification(filter != null ? filter : new RefRegionFilterDto());

        Specification<RefVillage> regionSpec = (root, query, cb) -> {
            if (filter != null && filter.getRegionId() != null) {
                return cb.equal(root.get("region").get("id"), filter.getRegionId());
            }
            if (filter != null && filter.getDistrictId() != null) {
                return cb.equal(root.get("district").get("id"), filter.getDistrictId());
            }
            if (filter != null && filter.getAyilAimakId() != null) {
                return cb.equal(root.get("ayilAimak").get("id"), filter.getAyilAimakId());
            }
            return cb.conjunction();
        };

        return baseSpec.and(regionSpec);
    }
}