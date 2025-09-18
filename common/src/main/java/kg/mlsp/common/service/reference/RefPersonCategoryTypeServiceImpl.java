package kg.mlsp.common.service.reference;

import kg.mlsp.common.dto.reference.RefBaseFilterDto;
import kg.mlsp.common.model.reference.RefPersonCategoryType;
import kg.mlsp.common.repository.reference.RefPersonCategoryTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class RefPersonCategoryTypeServiceImpl extends BaseRefServiceImpl<RefPersonCategoryType, Integer, RefBaseFilterDto> {
    public RefPersonCategoryTypeServiceImpl(RefPersonCategoryTypeRepository repository) {
        super(repository);
    }
}