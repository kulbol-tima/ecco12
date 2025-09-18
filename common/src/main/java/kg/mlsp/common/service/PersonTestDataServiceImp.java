package kg.mlsp.common.service;

import kg.mlsp.common.dto.person.PersonDto;
import kg.mlsp.common.model.RegPerson;

import kg.mlsp.common.repository.PersonRepository;
import kg.mlsp.integration.dto.passportinfo.PassportByPsnResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonTestDataServiceImp implements PersonTestDataService{

    private final PersonRepository personRepository;
    private final PersonService personService;


    @Override
    public PersonDto findPersonByPin(String pin) {
        return null;
    }
    @Override
    public PersonDto findFamilyMemberByPin(String pin) {
        return null;
    }

    @Override
    public RegPerson createTest(PassportByPsnResponseDto createDto) {

        var existingPerson = personRepository.findByPinAndIsActive(createDto.getPin(), true);
        if (existingPerson != null){
            return  existingPerson;
        }

        var person = personService.mapPersonPassportData(createDto);

        personRepository.save(person);

        return person;
    }

    @Override
    public List<RegPerson> list(){
       return personRepository.findAll();
    }



    public RegPerson find(Integer id) {
        var person = personRepository.findById(id).orElseThrow();
        return person;
    }
}