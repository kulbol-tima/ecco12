package kg.mlsp.common.service;

import kg.mlsp.common.dto.person.PersonFindDto;
import kg.mlsp.common.model.RegPerson;
import kg.mlsp.integration.dto.passportinfo.PassportByPsnResponseDto;
import kg.mlsp.integration.dto.zags.ZagsDataByPinResponseDto;

public interface PersonService {
    RegPerson findByPinAndIsActive(String pin);
    RegPerson createPerson(PersonFindDto personFindDto);
    RegPerson createPersonFromZags(PersonFindDto personFindDto);
    RegPerson mapPersonPassportData(PassportByPsnResponseDto passportData);
    RegPerson mapPersonZagsData(ZagsDataByPinResponseDto zagsData);

}
