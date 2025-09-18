package kg.mlsp.common.service;


import kg.mlsp.common.dto.reference.RefGeneralDto;
import kg.mlsp.common.mapper.RefGeneralMapper;
import kg.mlsp.common.model.reference.RefAppRequestType;
import kg.mlsp.common.repository.reference.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReferenceMapperServiceImp implements ReferenceMapperService {

    private final RefAppRequestTypeRepository refAppRequestTypeRepository;
    private final RefAyilAimakRepository refAyilAimakRepository;
    private final RefBankRepository refBankRepository;
    private final RefCountryRepository refCountryRepository;
    private final RefDistrictRepository refDistrictRepository;
    private final RefDistrictRepository refDocumentSerialRepository;
    private final RefEducationLevelRepository refEducationLevelRepository;
    private final RefEmploymentTypeRepository refEmploymentTypeRepository;
    private final RefExtensionTypeRepository refExtensionTypeRepository;
    private final RefGenderRepository refGenderRepository;
    private final RefIncomeTypeRepository refIncomeTypeRepository;
    private final RefMaritalStatusRepository refMaritalStatusRepository;
    private final RefNationalityRepository refNationalityRepository;
    private final RefOrganizationRepository refOrganizationRepository;
    private final RefPersonCategoryTypeRepository refPersonCategoryTypeRepository;
    private final RefPersonDocumentTypeRepository refPersonDocumentTypeRepository;
    private final RefDocumentTypeRepository refDocumentTypeRepository;
    private final RefRegionRepository refRegionRepository;
    private final RefRejectionReasonRepository refRejectionReasonRepository;
    private final RefRelationshipTypeRepository refRelationshipTypeRepository;
    private final RefStatusRepository refStatusRepository;
    private final RefVillageRepository refVillageRepository;


    private final RefGeneralMapper refGeneralMapper;

    @Override
    public RefGeneralDto getRequestTypeById(Integer id) {

        RefAppRequestType appRequestType = refAppRequestTypeRepository.findById(id).orElse(null);

        if (appRequestType != null)
        {
            return refGeneralMapper.toDto(appRequestType);
        }

        return null;
    }

    @Override
    public RefGeneralDto getAyilAimakById(Integer id) {
        var ref = refAyilAimakRepository.findById(id).orElse(null);
        if (ref != null)
        {
            return refGeneralMapper.toDto(ref);
        }
        return null;
    }

    @Override
    public RefGeneralDto getBankById(Integer id) {
        var ref = refBankRepository.findById(id).orElse(null);
        if (ref != null)
        {
            return refGeneralMapper.toDto(ref);
        }
        return null;
    }

    @Override
    public RefGeneralDto getCountryById(Integer id) {
        var ref = refCountryRepository.findById(id).orElse(null);
        if (ref != null)
        {
            return refGeneralMapper.toDto(ref);
        }
        return null;
    }

    @Override
    public RefGeneralDto getDistrictById(Integer id) {
        var ref = refDistrictRepository.findById(id).orElse(null);
        if (ref != null)
        {
            return refGeneralMapper.toDto(ref);
        }
        return null;
    }

    @Override
    public RefGeneralDto getDocumentSerialById(Integer id) {
        var ref = refDocumentSerialRepository.findById(id).orElse(null);
        if (ref != null)
        {
            return refGeneralMapper.toDto(ref);
        }
        return null;
    }

    @Override
    public RefGeneralDto getEducationLevelById(Integer id) {
        var ref = refEducationLevelRepository.findById(id).orElse(null);
        if (ref != null)
        {
            return refGeneralMapper.toDto(ref);
        }
        return null;
    }

    @Override
    public RefGeneralDto getEmploymentTypeById(Integer id) {
        var employmentType = refEmploymentTypeRepository.findById(id).orElse(null);
        if (employmentType != null)
        {
            return refGeneralMapper.toDto(employmentType);
        }
        return null;
    }

    @Override
    public RefGeneralDto getExtensionTypeById(Integer id) {
        var ref = refExtensionTypeRepository.findById(id).orElse(null);
        if (ref != null)
        {
            return refGeneralMapper.toDto(ref);
        }
        return null;
    }

    @Override
    public RefGeneralDto getGenderById(Integer id) {
        var ref = refGenderRepository.findById(id).orElse(null);
        if (ref != null)
        {
            return refGeneralMapper.toDto(ref);
        }
        return null;
    }

    @Override
    public RefGeneralDto getIncomeById(Integer id) {
        var ref = refIncomeTypeRepository.findById(id).orElse(null);
        if (ref != null)
        {
            return refGeneralMapper.toDto(ref);
        }
        return null;
    }

    @Override
    public RefGeneralDto getMartialStatusById(Integer id) {
        var ref = refMaritalStatusRepository.findById(id).orElse(null);
        if (ref != null)
        {
            return refGeneralMapper.toDto(ref);
        }
        return null;
    }

    @Override
    public RefGeneralDto getNationalityById(Integer id) {
        var ref = refNationalityRepository.findById(id).orElse(null);
        if (ref != null)
        {
            return refGeneralMapper.toDto(ref);
        }
        return null;
    }

    @Override
    public RefGeneralDto getOrganizationById(Integer id) {
        var ref = refOrganizationRepository.findById(id).orElse(null);
        if (ref != null)
        {
            return refGeneralMapper.toDto(ref);
        }
        return null;
    }

    @Override
    public RefGeneralDto getPersonCategoryById(Integer id) {
        var ref = refPersonCategoryTypeRepository.findById(id).orElse(null);
        if (ref != null)
        {
            return refGeneralMapper.toDto(ref);
        }
        return null;
    }

    @Override
    public RefGeneralDto getPersonDocumentTypeById(Integer id) {
        var ref = refPersonDocumentTypeRepository.findById(id).orElse(null);
        if (ref != null)
        {
            return refGeneralMapper.toDto(ref);
        }
        return null;
    }

    @Override
    public RefGeneralDto getDocumentTypeById(Integer id) {
        var ref = refDocumentTypeRepository.findById(id).orElse(null);
        if (ref != null)
        {
            return refGeneralMapper.toDto(ref);
        }
        return null;
    }


    @Override
    public RefGeneralDto getRegionById(Integer id) {
        var ref = refRegionRepository.findById(id).orElse(null);
        if (ref != null)
        {
            return refGeneralMapper.toDto(ref);
        }
        return null;
    }

    @Override
    public RefGeneralDto getRejectionReasonById(Integer id) {
        var ref = refRejectionReasonRepository.findById(id).orElse(null);
        if (ref != null)
        {
            return refGeneralMapper.toDto(ref);
        }
        return null;
    }

    @Override
    public RefGeneralDto getRelationshipTypeById(Integer id) {
        var ref = refRelationshipTypeRepository.findById(id).orElse(null);
        if (ref != null)
        {
            return refGeneralMapper.toDto(ref);
        }
        return null;
    }

    @Override
    public RefGeneralDto getStatusById(Integer id) {
        var ref = refStatusRepository.findById(id).orElse(null);
        if (ref != null)
        {
            return refGeneralMapper.toDto(ref);
        }
        return null;
    }

    @Override
    public RefGeneralDto getVillageById(Integer id) {
        var ref = refVillageRepository.findById(id).orElse(null);
        if (ref != null)
        {
            return refGeneralMapper.toDto(ref);
        }
        return null;
    }
}
