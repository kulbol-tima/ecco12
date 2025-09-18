package kg.mlsp.common.service.reference;

import kg.mlsp.common.dto.reference.RefBaseFilterDto;
import kg.mlsp.common.model.reference.RefMaritalStatus;
import kg.mlsp.common.repository.reference.RefMaritalStatusRepository;
import org.springframework.stereotype.Service;

@Service
public class RefMaritalStatusServiceImpl extends BaseRefServiceImpl<RefMaritalStatus, Integer, RefBaseFilterDto> {
    public RefMaritalStatusServiceImpl(RefMaritalStatusRepository repository) {
        super(repository);
    }
}