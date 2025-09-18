package kg.mlsp.common.service.reference;

import kg.mlsp.common.dto.reference.RefBaseFilterDto;
import kg.mlsp.common.model.reference.RefRejectionReason;
import kg.mlsp.common.repository.reference.RefRejectionReasonRepository;
import org.springframework.stereotype.Service;

@Service
public class RefRejectionReasonServiceImpl extends BaseRefServiceImpl<RefRejectionReason, Integer, RefBaseFilterDto> {
    public RefRejectionReasonServiceImpl(RefRejectionReasonRepository repository) {
        super(repository);
    }
}