package kg.mlsp.common.service.reference;

import kg.mlsp.common.dto.reference.RefBaseFilterDto;
import kg.mlsp.common.model.reference.RefBank;
import kg.mlsp.common.model.reference.RefCountry;
import kg.mlsp.common.repository.reference.RefBankRepository;
import kg.mlsp.common.repository.reference.RefCountryRepository;
import org.springframework.stereotype.Service;

@Service
public class RefCountryServiceImpl extends BaseRefServiceImpl<RefCountry, Integer, RefBaseFilterDto> {
    public RefCountryServiceImpl(RefCountryRepository repository) {
        super(repository);
    }
}