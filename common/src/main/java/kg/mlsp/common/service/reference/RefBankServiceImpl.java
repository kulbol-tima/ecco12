package kg.mlsp.common.service.reference;

import kg.mlsp.common.dto.reference.RefBaseFilterDto;
import kg.mlsp.common.model.reference.RefBank;
import kg.mlsp.common.repository.reference.RefBankRepository;
import org.springframework.stereotype.Service;

@Service
public class RefBankServiceImpl extends BaseRefServiceImpl<RefBank, Integer, RefBaseFilterDto> {
    public RefBankServiceImpl(RefBankRepository repository) {
        super(repository);
    }
}