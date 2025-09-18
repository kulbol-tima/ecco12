package kg.mlsp.common.service.reference;

import kg.mlsp.common.dto.reference.RefBaseFilterDto;
import kg.mlsp.common.model.reference.RefOrganization;
import kg.mlsp.common.repository.reference.RefOrganizationRepository;
import org.springframework.stereotype.Service;

@Service
public class RefOrganizationServiceImpl extends BaseRefServiceImpl<RefOrganization, Integer, RefBaseFilterDto> {
    public RefOrganizationServiceImpl(RefOrganizationRepository repository) {
        super(repository);
    }

    public String sync() {
        return "Synchronization completed successfully";
    }

}