package kg.mlsp.ubk.service;

import kg.mlsp.common.exception.ApiException;
import kg.mlsp.common.exception.ErrorCode;
import kg.mlsp.common.exception.ErrorMessage;
import kg.mlsp.common.model.reference.RefStatus;
import kg.mlsp.ubk.dto.application.UbkApplicationDto;
import kg.mlsp.ubk.mapper.UbkApplicationMapper;
import kg.mlsp.ubk.model.UbkApplication;
import kg.mlsp.ubk.repository.UbkApplicationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class UbkApplicationCheckServiceImp implements UbkApplicationCheckService {

    private final UbkApplicationRepository ubkApplicationRepository;
    private final UbkApplicationMapper ubkApplicationMapper;

    @Override
    public UbkApplicationDto duplicateCheck(Integer applicationId) {

        UbkApplication application = ubkApplicationRepository.findById(applicationId).orElseThrow(
                () -> new ApiException(ErrorCode.NOT_FOUND, String.format(ErrorMessage.APPLICATION_NOT_FOUND, applicationId))
        );
        if (application.getApplicantId() == null){
            throw  new ApiException(ErrorCode.NOT_FOUND, String.format(ErrorMessage.APPLICATION_APPLICANT_EMPTY, applicationId));
        }
        if (application.getApplicantPin() == null){
            throw  new ApiException(ErrorCode.NOT_FOUND, String.format(ErrorMessage.APPLICATION_APPLICANT_PIN_EMPTY, applicationId));
        }

        List<UbkApplication> list = ubkApplicationRepository.findActiveDuplicates(
                application.getApplicantPin(),
                application.getId(),
                RefStatus.UBK_ACTIVE_STATUSES,
                PageRequest.of(0, 1)
        );

        UbkApplication duplicateApp = list.stream().findFirst().orElse(null);

        if (duplicateApp != null) {
            return ubkApplicationMapper.toDto(duplicateApp);
        }

        return null;
    }
}
