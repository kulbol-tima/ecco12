package kg.mlsp.common.service.reference;

import kg.mlsp.common.dto.reference.RefBaseFilterDto;
import kg.mlsp.common.model.reference.RefEmploymentType;
import kg.mlsp.common.repository.reference.RefEmploymentTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class RefEmploymentTypeServiceImpl extends BaseRefServiceImpl<RefEmploymentType, Integer, RefBaseFilterDto> {
    public RefEmploymentTypeServiceImpl(RefEmploymentTypeRepository repository) {
        super(repository);
    }
}