package kg.mlsp.common.service.reference;

import kg.mlsp.common.dto.reference.RefBaseFilterDto;
import kg.mlsp.common.model.reference.RefAnimalType;
import kg.mlsp.common.repository.reference.RefAnimalTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class RefAnimalTypeServiceImpl extends BaseRefServiceImpl<RefAnimalType, Integer, RefBaseFilterDto> {
    public RefAnimalTypeServiceImpl(RefAnimalTypeRepository repository) {
        super(repository);
    }
}