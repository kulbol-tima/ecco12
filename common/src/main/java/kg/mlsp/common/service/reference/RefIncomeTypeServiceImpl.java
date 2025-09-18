package kg.mlsp.common.service.reference;

import kg.mlsp.common.dto.reference.RefBaseFilterDto;
import kg.mlsp.common.model.reference.RefIncomeType;
import kg.mlsp.common.repository.reference.RefIncomeTypeRepository;
import org.springframework.stereotype.Service;

@Service
public class RefIncomeTypeServiceImpl extends BaseRefServiceImpl<RefIncomeType, Integer, RefBaseFilterDto> {
    public RefIncomeTypeServiceImpl(RefIncomeTypeRepository repository) {
        super(repository);
    }
}