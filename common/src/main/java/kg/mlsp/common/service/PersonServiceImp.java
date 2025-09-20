package kg.mlsp.common.service;


import kg.mlsp.common.dto.person.PersonFindDto;
import kg.mlsp.common.model.RegPerson;
import kg.mlsp.common.model.RegPersonIdentity;
import kg.mlsp.common.model.reference.RefDocumentSerial;
import kg.mlsp.common.model.reference.RefGender;
import kg.mlsp.common.model.reference.RefMaritalStatus;
import kg.mlsp.common.model.reference.RefNationality;
import kg.mlsp.common.repository.PersonIdentityRepository;
import kg.mlsp.common.repository.PersonRepository;
import kg.mlsp.common.repository.reference.RefDocumentSerialRepository;
import kg.mlsp.common.repository.reference.RefGenderRepository;
import kg.mlsp.common.repository.reference.RefMaritalStatusRepository;
import kg.mlsp.common.repository.reference.RefNationalityRepository;
import kg.mlsp.common.utils.DataFormatterUtils;
import kg.mlsp.integration.dto.passportinfo.PassportByPsnResponseDto;
import kg.mlsp.integration.dto.zags.ZagsDataByPinResponseDto;
import kg.mlsp.integration.service.PassportFeignClient;
import kg.mlsp.integration.service.ZagsFeignClient;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class PersonServiceImp  implements PersonService {

    private final RefDocumentSerialRepository documentSerialRepository;
    private final RefGenderRepository genderRepository;
    private final RefMaritalStatusRepository maritalStatusRepository;
    private final RefNationalityRepository nationalityRepository;
    private final PassportFeignClient passportFeignClient;
    private final ZagsFeignClient zagsFeignClient;

    private final PersonRepository personRepository;
    private final PersonIdentityRepository personIdentityRepository;


    @Override
    public RegPerson findByPinAndIsActive(String pin) {
        return personRepository.findByPinAndIsActive(pin, true);
    }

    @Override
    public RegPerson createPerson(PersonFindDto personFindDto) {
        RegPerson existPerson = findExistingPerson(personFindDto);
        if (existPerson != null) {
            return existPerson;
        }

        PassportByPsnResponseDto passportData;

        try {
            RefDocumentSerial documentSerial = documentSerialRepository.findById(personFindDto.getDocumentSerialId()).orElseThrow(
                    () -> new RuntimeException("Document serial not found")
            );
            passportData = passportFeignClient.getDataByPsn(
                    personFindDto.getPin(),
                    documentSerial.getCode(),
                    personFindDto.getDocumentNumber()
            );

            RegPerson newPerson = mapPersonPassportData(passportData);
            newPerson.setRefDocumentSerial(documentSerialRepository.findById(personFindDto.getDocumentSerialId()).orElse(null));
            newPerson.setIsPassportData(true);
            newPerson.setIsActive(true);

            setPersonIdentity(newPerson);
            ZagsDataByPinResponseDto zagsData = getZagsData(personFindDto.getPin());
            if (zagsData != null){
                RegPerson zagsPerson = mapPersonZagsData(zagsData);
                newPerson.setRefMaritalStatus(zagsPerson.getRefMaritalStatus());
                newPerson.setDeathDate(zagsPerson.getDeathDate());
                personRepository.save(newPerson);
            }

            return newPerson;

        }catch (Exception e){
            log.error("Error fetching passport data: {}", e.getMessage());
            return createPersonFromZags(personFindDto);
        }
    }

    @Override
    public RegPerson createPersonFromZags(PersonFindDto personFindDto) {
        RegPerson existPerson = findExistingPerson(personFindDto);
        if (existPerson != null) {
            return existPerson;
        }

        ZagsDataByPinResponseDto zagsData = getZagsData(personFindDto.getPin());
        if(zagsData != null){
            RegPerson newPerson = mapPersonZagsData(zagsData);
            newPerson.setPassportNumber(personFindDto.getDocumentNumber());
            newPerson.setRefDocumentSerial(documentSerialRepository.findById(personFindDto.getDocumentSerialId()).orElse(null));
            newPerson.setIsPassportData(false);
            newPerson.setIsActive(true);
            setPersonIdentity(newPerson);
            return newPerson;
        }

        throw new RuntimeException("Записей из ЗАГС не найдено");
    }

    private RegPerson findExistingPerson(PersonFindDto personFindDto) {
        RefDocumentSerial documentSerial = documentSerialRepository.findById(personFindDto.getDocumentSerialId()).orElseThrow(
                () -> new RuntimeException("Document serial not found")
        );
        return personRepository.findOneByPinAndRefDocumentSerialAndPassportNumber(
                personFindDto.getPin(),
                documentSerial,
                personFindDto.getDocumentNumber()
        );
    }

    private ZagsDataByPinResponseDto getZagsData(String pin) {
        try {
            return zagsFeignClient.getDataByPin(pin);
        } catch (Exception e) {
            log.error("Error fetching ZAGS data: {}", e.getMessage());
            return null;
        }
    }

    private void setPersonIdentity(RegPerson newPerson) {
        var personList = personRepository.findAllByPinAndIsActive(newPerson.getPin(), true);
        if (personList != null) {
            for (RegPerson person : personList) {
                if (newPerson.getId() == null || !person.getId().equals(newPerson.getId())) {
                    person.setIsActive(false);
                    personRepository.save(person);
                }
            }
        }

        RegPersonIdentity personIdentity = personIdentityRepository.findOneByPin(newPerson.getPin());
        if (personIdentity == null) {
            personIdentity = new RegPersonIdentity();
            personIdentity.setPin(newPerson.getPin());
            personIdentityRepository.save(personIdentity);
        }
        newPerson.setPersonIdentity(personIdentity);
        personRepository.save(newPerson);
    }

    public RegPerson mapPersonPassportData(PassportByPsnResponseDto passportData)
    {
        RefGender gender = genderRepository.findById(passportData.getGenderId()).orElse(null);
        RefNationality refNationality = null;
        if (passportData.getNationality() != null) {
            refNationality = nationalityRepository.findOneByCode(passportData.getNationality().toLowerCase());
        }

        RegPerson newPerson = new RegPerson();
        newPerson.setPin(passportData.getPin());

        newPerson.setSurname(capitalize(passportData.getSurname()));
        newPerson.setName(capitalize(passportData.getName()));
        newPerson.setPatronymic(capitalize(passportData.getPatronymic()));
        newPerson.setNationality(capitalize(passportData.getNationality()));
        newPerson.setDateOfBirth(DataFormatterUtils.formatStringToDate(passportData.getDateOfBirth()));
        newPerson.setPassportSeries(passportData.getPassportSeries());
        newPerson.setPassportNumber(passportData.getPassportNumber());
        newPerson.setPassportAuthority(passportData.getPassportAuthority());
        newPerson.setIssuedDate(DataFormatterUtils.formatStringToDate(passportData.getIssuedDate()));
        newPerson.setExpiredDate(DataFormatterUtils.formatStringToDate(passportData.getExpiredDate()));
        newPerson.setFamilyStatus(passportData.getFamilyStatus());
        newPerson.setGender(passportData.getGender());
        newPerson.setAddressRegion(passportData.getAddressRegion());
        newPerson.setAddressLocality(passportData.getAddressLocality());
        newPerson.setAddressStreet(passportData.getAddressStreet());
        newPerson.setAddressHouse(passportData.getAddressHouse());
        newPerson.setAddressBuilding(passportData.getAddressBuilding());
        newPerson.setAddressApartment(passportData.getAddressApartment());
        newPerson.setRegionId(passportData.getRegionId());
        newPerson.setDistrictId(passportData.getDistrictId());
        newPerson.setAreaId(passportData.getAreaId());
        newPerson.setSubareaId(passportData.getSubareaId());
        newPerson.setStreetId(passportData.getStreetId());
        newPerson.setHouseId(passportData.getHouseId());

        newPerson.setRefGender(gender);
        newPerson.setRefNationality(refNationality);

        return newPerson;
    }

    public RegPerson mapPersonZagsData(ZagsDataByPinResponseDto zagsData) {
        RefGender gender = genderRepository.findById(zagsData.getGenderId()).orElse(null);
        RefMaritalStatus maritalStatus = maritalStatusRepository.findOneByCode(zagsData.getMaritalStatusCode());

        RegPerson newPerson = new RegPerson();
        newPerson.setPin(zagsData.getPin());
        newPerson.setSurname(capitalize(zagsData.getSurname()));
        newPerson.setName(capitalize(zagsData.getName()));
        newPerson.setPatronymic(capitalize(zagsData.getPatronymic()));
        newPerson.setNationality(capitalize(zagsData.getNationality()));
        newPerson.setDateOfBirth(DataFormatterUtils.formatStringToDate(zagsData.getDateOfBirth()));
        newPerson.setGender(zagsData.getGenderCode());
        newPerson.setRefGender(gender);
        newPerson.setRefMaritalStatus(maritalStatus);

        if (zagsData.getDeathDate() != null && !zagsData.getDeathDate().isEmpty()) {
            newPerson.setDeathDate(DataFormatterUtils.formatStringToDate(zagsData.getDeathDate()));
        }

        return newPerson;
    }

    private String capitalize(String value) {
        if (value == null || value.isBlank()) {
            return value;
        }
        value = value.trim().toLowerCase();
        return value.substring(0, 1).toUpperCase() + value.substring(1);
    }

}

