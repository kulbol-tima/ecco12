package kg.mlsp.common.service.reference;

import kg.mlsp.common.dto.reference.RefRegionFilterDto;
import kg.mlsp.common.model.reference.RefDistrict;
import kg.mlsp.common.repository.reference.RefDistrictRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class RefDistrictServiceImpl extends BaseRefServiceImpl<RefDistrict, Integer, RefRegionFilterDto> {

    public RefDistrictServiceImpl(RefDistrictRepository repository) {
        super(repository);
    }

    @Override
    protected Specification<RefDistrict> buildSpecification(RefRegionFilterDto filter) {
        Specification<RefDistrict> baseSpec = super.buildSpecification(filter != null ? filter : new RefRegionFilterDto());

        Specification<RefDistrict> regionSpec = (root, query, cb) -> {
            if (filter != null && filter.getRegionId() != null) {
                return cb.equal(root.get("region").get("id"), filter.getRegionId());
            }
            return cb.conjunction();
        };

        return baseSpec.and(regionSpec);
    }
}
