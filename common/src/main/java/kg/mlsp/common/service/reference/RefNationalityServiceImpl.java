package kg.mlsp.common.service.reference;

import kg.mlsp.common.dto.reference.RefBaseFilterDto;
import kg.mlsp.common.model.reference.RefNationality;
import kg.mlsp.common.repository.reference.RefNationalityRepository;
import org.springframework.stereotype.Service;

@Service
public class RefNationalityServiceImpl extends BaseRefServiceImpl<RefNationality, Integer, RefBaseFilterDto> {
    public RefNationalityServiceImpl(RefNationalityRepository repository) {
        super(repository);
    }
}
