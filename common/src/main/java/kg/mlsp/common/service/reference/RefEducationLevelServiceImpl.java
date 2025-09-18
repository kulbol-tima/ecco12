package kg.mlsp.common.service.reference;

import kg.mlsp.common.dto.reference.RefBaseFilterDto;
import kg.mlsp.common.model.reference.RefEducationLevel;
import kg.mlsp.common.repository.reference.RefEducationLevelRepository;
import org.springframework.stereotype.Service;

@Service
public class RefEducationLevelServiceImpl extends BaseRefServiceImpl<RefEducationLevel, Integer, RefBaseFilterDto> {
    public RefEducationLevelServiceImpl(RefEducationLevelRepository repository) {
        super(repository);
    }
}