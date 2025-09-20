package kg.mlsp.ubk.service;

import kg.mlsp.common.dto.person.PersonDto;
import kg.mlsp.common.dto.person.PersonFilterDto;
import kg.mlsp.common.dto.person.PersonFindDto;
import kg.mlsp.common.exception.ErrorMessage;
import kg.mlsp.common.exception.SuccessMessage;
import kg.mlsp.common.mapper.PersonMapper;
import kg.mlsp.common.model.RegPerson;
import kg.mlsp.common.exception.ApiException;
import kg.mlsp.common.exception.ErrorCode;
import kg.mlsp.common.repository.PersonRepository;
import kg.mlsp.common.service.PersonService;
import kg.mlsp.common.specification.RegPersonSpecification;
import kg.mlsp.ubk.dto.application.UbkApplicationCreateDto;
import kg.mlsp.ubk.dto.application.UbkApplicationDto;
import kg.mlsp.ubk.dto.application.UbkApplicationFilterDto;
import kg.mlsp.ubk.dto.application.UbkApplicationListDto;
import kg.mlsp.ubk.mapper.UbkApplicationMapper;
import kg.mlsp.ubk.model.UbkApplication;
import kg.mlsp.ubk.repository.UbkApplicationRepository;
import kg.mlsp.ubk.specification.UbkApplicationSpecification;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class UbkApplicationServiceImpl implements UbkApplicationService {

    private final UbkApplicationMapper applicationMapper;
    private final UbkApplicationRepository ubkApplicationRepository;
    private final PersonRepository personRepository;
    private final PersonService personService;
    private final PersonMapper personMapper;


    public Page<UbkApplicationListDto> getAll(UbkApplicationFilterDto filterDto, Pageable pageable) {

        List<Integer> applicantIds = null;
        PersonFilterDto personFilter = buildPersonFilter(filterDto);

        if(!personFilter.isEmpty()){
            applicantIds = personRepository.findAll(RegPersonSpecification.filterBy(personFilter)).stream()
                    .map(RegPerson::getId)
                    .toList();
        }

        var applications = ubkApplicationRepository.findAll(
                UbkApplicationSpecification.filterBy(filterDto, applicantIds),
                pageable
        );

        return applications.map(applicationMapper::toDtoList);
    }


    @Override
    public PersonDto findPerson(PersonFindDto findDto) {
        var person = personService.findByPinAndIsActive(findDto.getPin());
        if (person != null) {
            return personMapper.toDto(person);
        }
        person = personService.createPerson(findDto);
        return personMapper.toDto(person);
    }

    public UbkApplicationDto create(UbkApplicationCreateDto createDto) {

        var application = new UbkApplication();
        application.setRegistrationNumber(GenerateRegistrationNumber());
        application.setRegistrationDate(createDto.getRegistrationDate());

        application.setRequestTypeId(createDto.getRequestTypeId());
        application.setApplicantId(createDto.getApplicantId());
        application.setEmploymentTypeId(createDto.getEmploymentTypeId());
        application.setPersonCategoryId(createDto.getPersonCategoryId());

        application.setPhone(createDto.getPhone());
        application.setEmail(createDto.getEmail());
        application.setReason(createDto.getReason());
        application.setComment(createDto.getComment());
        application.setAttachmentsCount(createDto.getAttachmentsCount());

        application = ubkApplicationRepository.save(application);

        log.info("Created application with ID: {}", application.getId());

        return applicationMapper.toDto(application);
    }

    public UbkApplicationDto update(Integer applicationId, UbkApplicationCreateDto createDto) {

        var application = ubkApplicationRepository.findById(applicationId).orElse(null);
        if (application == null) {
            throw new ApiException(ErrorCode.NOT_FOUND,  String.format(ErrorMessage.APPLICATION_NOT_FOUND, applicationId));
        }

        application.setRegistrationDate(createDto.getRegistrationDate());

        application.setRequestTypeId(createDto.getRequestTypeId());
        application.setApplicantId(createDto.getApplicantId());
        application.setEmploymentTypeId(createDto.getEmploymentTypeId());
        application.setPersonCategoryId(createDto.getPersonCategoryId());

        application.setPhone(createDto.getPhone());
        application.setEmail(createDto.getEmail());
        application.setReason(createDto.getReason());
        application.setComment(createDto.getComment());
        application.setAttachmentsCount(createDto.getAttachmentsCount());
        application = ubkApplicationRepository.save(application);

        log.info("Updated application with ID: {}", application.getId());

        return applicationMapper.toDto(application);
    }

    public UbkApplicationDto getById(Integer id) {

        var application = ubkApplicationRepository.findById(id)
                .orElseThrow(() -> new ApiException(ErrorCode.NOT_FOUND,
                        String.format(ErrorMessage.APPLICATION_NOT_FOUND, id)));

        return applicationMapper.toDto(application);
    }


    @Override
    public String delete(Integer id) {
        var application = ubkApplicationRepository.findById(id).orElseThrow(
                () -> new ApiException(ErrorCode.NOT_FOUND, String.format(ErrorMessage.APPLICATION_NOT_FOUND, id)));

        application.markAsDeleted();
        ubkApplicationRepository.save(application);

        return SuccessMessage.RECORD_DELETED;
    }


    private String GenerateRegistrationNumber() {
        return "UBK-" + System.currentTimeMillis();
    }


    private PersonFilterDto buildPersonFilter(UbkApplicationFilterDto ubkApplicationFilterDto) {
        PersonFilterDto filter = new PersonFilterDto();
        filter.setId(ubkApplicationFilterDto.getApplicantId());
        filter.setPin(ubkApplicationFilterDto.getApplicantPin());
        filter.setFirstName(ubkApplicationFilterDto.getFirstName());
        filter.setSecondName(ubkApplicationFilterDto.getSecondName());
        filter.setMiddleName(ubkApplicationFilterDto.getMiddleName());
        filter.setDocumentSerialId(ubkApplicationFilterDto.getDocumentSerialId());
        filter.setDocumentNumber(ubkApplicationFilterDto.getDocumentNumber());
        return filter;
    }
}
