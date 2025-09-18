package kg.mlsp.common.service.reference;

import kg.mlsp.common.dto.reference.RefBaseFilterDto;
import kg.mlsp.common.model.reference.RefExtensionType;
import kg.mlsp.common.repository.reference.RefExtensionTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class RefExtensionTypeServiceImpl extends BaseRefServiceImpl<RefExtensionType, Integer, RefBaseFilterDto> {
    public RefExtensionTypeServiceImpl(RefExtensionTypeRepository repository) {
        super(repository);
    }
}