package kg.mlsp.common.service.reference;

import kg.mlsp.common.dto.reference.RefBaseFilterDto;
import kg.mlsp.common.model.reference.RefDocumentType;
import kg.mlsp.common.repository.reference.RefDocumentTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class RefDocumentTypeServiceImpl extends BaseRefServiceImpl<RefDocumentType, Integer, RefBaseFilterDto> {
    public RefDocumentTypeServiceImpl(RefDocumentTypeRepository repository) {
        super(repository);
    }
}