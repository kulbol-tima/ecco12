package kg.mlsp.common.service.reference;

import kg.mlsp.common.dto.reference.RefBaseFilterDto;
import kg.mlsp.common.model.reference.RefPersonDocumentType;
import kg.mlsp.common.repository.reference.RefPersonDocumentTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class RefPersonDocumentTypeServiceImpl extends BaseRefServiceImpl<RefPersonDocumentType, Integer, RefBaseFilterDto> {
    public RefPersonDocumentTypeServiceImpl(RefPersonDocumentTypeRepository repository) {
        super(repository);
    }
}