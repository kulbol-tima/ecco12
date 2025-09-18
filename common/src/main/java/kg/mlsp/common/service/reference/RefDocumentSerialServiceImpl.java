package kg.mlsp.common.service.reference;

import kg.mlsp.common.dto.reference.RefBaseFilterDto;
import kg.mlsp.common.model.reference.RefCountry;
import kg.mlsp.common.model.reference.RefDocumentSerial;
import kg.mlsp.common.repository.reference.RefCountryRepository;
import kg.mlsp.common.repository.reference.RefDocumentSerialRepository;
import org.springframework.stereotype.Service;

@Service
public class RefDocumentSerialServiceImpl extends BaseRefServiceImpl<RefDocumentSerial, Integer, RefBaseFilterDto> {
    public RefDocumentSerialServiceImpl(RefDocumentSerialRepository repository) {
        super(repository);
    }
}