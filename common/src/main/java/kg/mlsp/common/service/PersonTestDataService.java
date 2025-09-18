package kg.mlsp.common.service;

import kg.mlsp.common.dto.person.PersonDto;
import kg.mlsp.common.model.RegPerson;
import kg.mlsp.integration.dto.passportinfo.PassportByPsnResponseDto;

import java.util.List;

public interface PersonTestDataService {
    PersonDto findPersonByPin(String pin);
    PersonDto findFamilyMemberByPin(String pin);

    RegPerson createTest(PassportByPsnResponseDto createDto);
    RegPerson find(Integer id);
    List<RegPerson> list();
}
