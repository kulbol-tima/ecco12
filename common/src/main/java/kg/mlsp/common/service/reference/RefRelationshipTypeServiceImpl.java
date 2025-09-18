package kg.mlsp.common.service.reference;

import kg.mlsp.common.dto.reference.RefBaseFilterDto;
import kg.mlsp.common.model.reference.RefRelationshipType;
import kg.mlsp.common.repository.reference.RefRelationshipTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class RefRelationshipTypeServiceImpl extends BaseRefServiceImpl<RefRelationshipType, Integer, RefBaseFilterDto> {
    public RefRelationshipTypeServiceImpl(RefRelationshipTypeRepository repository) {
        super(repository);
    }
}