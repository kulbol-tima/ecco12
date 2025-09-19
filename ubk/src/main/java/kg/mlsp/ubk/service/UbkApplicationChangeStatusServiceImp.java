package kg.mlsp.ubk.service;

import kg.mlsp.common.exception.ApiException;
import kg.mlsp.common.exception.ErrorCode;
import kg.mlsp.common.exception.ErrorMessage;
import kg.mlsp.common.exception.SuccessMessage;
import kg.mlsp.common.model.RegPerson;
import kg.mlsp.common.model.reference.RefRejectionReason;
import kg.mlsp.common.model.reference.RefStatus;
import kg.mlsp.common.repository.PersonRepository;
import kg.mlsp.ubk.dto.ChangeStatusRequestDto;
import kg.mlsp.ubk.dto.application.UbkApplicationDto;
import kg.mlsp.ubk.model.UbkApplication;
import kg.mlsp.ubk.repository.UbkApplicationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Slf4j
@Service
@RequiredArgsConstructor
public class UbkApplicationChangeStatusServiceImp implements UbkApplicationChangeStatusService {

    private final UbkApplicationRepository ubkApplicationRepository;
    private final UbkApplicationCheckService ubkApplicationCheckService;
    private final UbkApplicationHistoryService ubkApplicationHistoryService;
    private final PersonRepository personRepository;


    @Override
    public String changeStatus(Integer applicationId, ChangeStatusRequestDto changeStatusDto) {

        UbkApplication application = ubkApplicationRepository.findById(applicationId).orElseThrow(
                () -> new ApiException(ErrorCode.NOT_FOUND,  String.format(ErrorMessage.APPLICATION_NOT_FOUND, applicationId))
        );

        if (application.getStatusId() != null && !application.getStatusId().equals(changeStatusDto.getStatusId())) {
            changeStatusDto.setOldStatusId(application.getStatusId());
        }

        //Проверка на дублирующие заявления.
        if (changeStatusDto.getStatusId() != null && RefStatus.UBK_ACTIVE_STATUSES.contains(changeStatusDto.getStatusId())){
            checkIsDuplicate(applicationId, changeStatusDto);
            checkPersonDocumentIsValid(applicationId, changeStatusDto);
        }

        application.setStatusId(changeStatusDto.getStatusId());
        ubkApplicationRepository.save(application);
        ubkApplicationHistoryService.saveHistory(application.getId(), changeStatusDto);

        return SuccessMessage.STATUS_CHANGED;
    }

    private void checkPersonDocumentIsValid(Integer applicationId, ChangeStatusRequestDto changeStatusDto){
        UbkApplication application = ubkApplicationRepository.findById(applicationId).orElseThrow(
                () -> new ApiException(ErrorCode.NOT_FOUND, String.format(ErrorMessage.APPLICATION_NOT_FOUND, applicationId))
        );
        if (application.getApplicantId() == null){
            throw  new ApiException(ErrorCode.NOT_FOUND, String.format(ErrorMessage.APPLICATION_APPLICANT_EMPTY, applicationId));
        }
        RegPerson applicant = personRepository.findById(application.getApplicantId()).orElseThrow(
                () -> new ApiException(ErrorCode.NOT_FOUND, String.format(ErrorMessage.PERSON_NOT_FOUND, application.getApplicantId()))
        );


        if (applicant.getExpiredDate() == null  || applicant.getExpiredDate().isBefore(LocalDate.now())){
            String message = "У заявителя просрочен документ. ПИН: " + applicant.getPin() +
                    ", Срок действия документа истек: " + (applicant.getExpiredDate() != null ? applicant.getExpiredDate().toString() : "не указан");

            changeStatusDto.setOldStatusId(application.getStatusId());
            changeStatusDto.setComment(message);
            changeStatusDto.setStatusId(RefStatus.REJECTED);
            changeStatusDto.setRejectionReasonId(RefRejectionReason.DOCUMENT_EXPIRED);

            application.setStatusId(RefStatus.REJECTED);
            application.setRejectedReason(message);

            ubkApplicationRepository.save(application);
            ubkApplicationHistoryService.saveHistory(applicationId, changeStatusDto);
            throw new ApiException(ErrorCode.BAD_REQUEST, message);
        }
    }

    private void checkIsDuplicate(Integer applicationId, ChangeStatusRequestDto changeStatusDto){

       UbkApplicationDto applicationDto =  ubkApplicationCheckService.duplicateCheck(applicationId);
       if (applicationDto != null){

           UbkApplication application = ubkApplicationRepository.findById(applicationId).orElseThrow(
                   () -> new ApiException(ErrorCode.NOT_FOUND, String.format(ErrorMessage.APPLICATION_NOT_FOUND, applicationId))
              );

           String message = "Заявление является дублирующим. Номер заявления: " + applicationDto.getRegistrationNumber() +
                   ", Организация: " + applicationDto.getOrganizationId() +
                   ", Статус: " + applicationDto.getStatusId();

           changeStatusDto.setOldStatusId(application.getStatusId());
           changeStatusDto.setComment(message);
           changeStatusDto.setStatusId(RefStatus.REJECTED);
           changeStatusDto.setRejectionReasonId(RefRejectionReason.DUPLICATE);

           application.setStatusId(RefStatus.REJECTED);
           application.setRejectedReason(message);

           ubkApplicationRepository.save(application);
           ubkApplicationHistoryService.saveHistory(applicationId, changeStatusDto);

           throw new ApiException(ErrorCode.BAD_REQUEST, message);

       }
    }
}
