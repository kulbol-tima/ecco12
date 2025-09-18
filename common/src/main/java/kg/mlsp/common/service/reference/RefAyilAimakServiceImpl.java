package kg.mlsp.common.service.reference;

import kg.mlsp.common.dto.reference.RefRegionFilterDto;
import kg.mlsp.common.model.reference.RefAyilAimak;
import kg.mlsp.common.repository.reference.RefAyilAimakRepository;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

@Service
public class RefAyilAimakServiceImpl extends BaseRefServiceImpl<RefAyilAimak, Integer, RefRegionFilterDto> {
    public RefAyilAimakServiceImpl(RefAyilAimakRepository repository) {
        super(repository);
    }


    @Override
    protected Specification<RefAyilAimak> buildSpecification(RefRegionFilterDto filter) {
        Specification<RefAyilAimak> baseSpec = super.buildSpecification(filter != null ? filter : new RefRegionFilterDto());

        Specification<RefAyilAimak> regionSpec = (root, query, cb) -> {
            if (filter != null && filter.getRegionId() != null) {
                return cb.equal(root.get("region").get("id"), filter.getRegionId());
            }
            if (filter != null && filter.getDistrictId() != null) {
                return cb.equal(root.get("district").get("id"), filter.getDistrictId());
            }

            return cb.conjunction();
        };

        return baseSpec.and(regionSpec);
    }

}