package kg.mlsp.common.service.reference;

import kg.mlsp.common.dto.reference.RefBaseFilterDto;
import kg.mlsp.common.model.reference.RefAppRequestType;
import kg.mlsp.common.repository.reference.RefAppRequestTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class RefAppRequestTypeServiceImpl extends BaseRefServiceImpl<RefAppRequestType, Integer, RefBaseFilterDto> {
    public RefAppRequestTypeServiceImpl(RefAppRequestTypeRepository repository) {
        super(repository);
    }
}