package kg.mlsp.common.service;

import kg.mlsp.common.dto.reference.RefGeneralDto;

public interface ReferenceMapperService {
    RefGeneralDto getRequestTypeById(Integer id);
    RefGeneralDto getAyilAimakById(Integer id);
    RefGeneralDto getBankById(Integer id);
    RefGeneralDto getCountryById(Integer id);
    RefGeneralDto getDistrictById(Integer id);
    RefGeneralDto getDocumentSerialById(Integer id);
    RefGeneralDto getEducationLevelById(Integer id);
    RefGeneralDto getEmploymentTypeById(Integer id);
    RefGeneralDto getExtensionTypeById(Integer id);
    RefGeneralDto getGenderById(Integer id);
    RefGeneralDto getIncomeById(Integer id);
    RefGeneralDto getMartialStatusById(Integer id);
    RefGeneralDto getNationalityById(Integer id);
    RefGeneralDto getOrganizationById(Integer id);
    RefGeneralDto getPersonCategoryById(Integer id);
    RefGeneralDto getPersonDocumentTypeById(Integer id);
    RefGeneralDto getDocumentTypeById(Integer id);
    RefGeneralDto getRegionById(Integer id);
    RefGeneralDto getRejectionReasonById(Integer id);
    RefGeneralDto getRelationshipTypeById(Integer id);
    RefGeneralDto getStatusById(Integer id);
    RefGeneralDto getVillageById(Integer id);

}
