package kg.mlsp.common.service.reference;

import kg.mlsp.common.dto.reference.RefBaseFilterDto;
import kg.mlsp.common.model.reference.RefRegion;
import kg.mlsp.common.repository.reference.RefRegionRepository;
import org.springframework.stereotype.Service;

@Service
public class RefRegionServiceImpl extends BaseRefServiceImpl<RefRegion, Integer, RefBaseFilterDto> {
    public RefRegionServiceImpl(RefRegionRepository repository) {
        super(repository);
    }
}