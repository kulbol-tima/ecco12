package kg.mlsp.common.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import kg.mlsp.common.dto.person.PersonDto;
import kg.mlsp.common.model.RegPerson;
import kg.mlsp.common.service.PersonTestDataService;
import kg.mlsp.integration.dto.passportinfo.PassportByPsnResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/person-test-data")
@Tag(name = "Person", description = "Person Test Data Management")
public class PersonTestDataController {
    private final PersonTestDataService personTestDataService;

    public PersonTestDataController(PersonTestDataService personTestDataService) {
        this.personTestDataService = personTestDataService;
    }


    @PostMapping("/create")
    public ResponseEntity<RegPerson> create(@RequestBody PassportByPsnResponseDto createDto) {
        var personDto = personTestDataService.createTest(createDto);
        return ResponseEntity.ok(personDto);
    }

    @GetMapping("/list")
    public ResponseEntity<List<RegPerson>> list() {
        var list = personTestDataService.list();
        return ResponseEntity.ok(list);
    }

    @GetMapping("/{id}")
    public ResponseEntity<RegPerson> find(@PathVariable Integer id) {
        var personDto = personTestDataService.find(id);
        return ResponseEntity.ok(personDto);
    }


    @GetMapping("/applicant/{pin}")
    public ResponseEntity<PersonDto> getPerson(@PathVariable String pin) {
        var personDto = personTestDataService.findPersonByPin(pin);
        return ResponseEntity.ok(personDto);
    }


    @GetMapping("/family-member/{pin}")
    public ResponseEntity<PersonDto> getFamilyMember(@PathVariable String pin) {
        var personDto = personTestDataService.findFamilyMemberByPin(pin);
        return ResponseEntity.ok(personDto);
    }

}
