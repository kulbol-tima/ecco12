package kg.mlsp.ubk.service;

import kg.mlsp.common.exception.ApiException;
import kg.mlsp.common.exception.ErrorCode;
import kg.mlsp.common.exception.ErrorMessage;
import kg.mlsp.common.utils.RequestUtils;
import kg.mlsp.ubk.dto.ChangeStatusRequestDto;
import kg.mlsp.ubk.dto.application.UbkApplicationHistoryDto;
import kg.mlsp.ubk.mapper.UbkApplicationHistoryMapper;
import kg.mlsp.ubk.model.UbkApplication;
import kg.mlsp.ubk.model.UbkApplicationHistory;
import kg.mlsp.ubk.repository.UbkApplicationHistoryRepository;
import kg.mlsp.ubk.repository.UbkApplicationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UbkApplicationHistoryServiceImp implements UbkApplicationHistoryService {


    private final UbkApplicationRepository ubkApplicationRepository;
    private final UbkApplicationHistoryRepository ubkApplicationHistoryRepository;
    private final UbkApplicationHistoryMapper ubkApplicationHistoryMapper;

    @Override
    public void saveHistory(Integer applicationId, ChangeStatusRequestDto changeStatusDto) {

        UbkApplicationHistory history = new UbkApplicationHistory();

        UbkApplication application = ubkApplicationRepository.findById(applicationId).orElseThrow(()
                -> new ApiException(ErrorCode.NOT_FOUND,  String.format(ErrorMessage.APPLICATION_NOT_FOUND, applicationId))
        );

        history.setApplication(application);

        history.setStatusId(changeStatusDto.getStatusId());
        history.setOldStatusId(changeStatusDto.getOldStatusId());
        history.setRejectionReasonId(changeStatusDto.getRejectionReasonId());

        history.setIpAddress(RequestUtils.getClientIp());
        history.setComment(changeStatusDto.getComment());
        ubkApplicationHistoryRepository.save(history);

    }


    @Override
    public List<UbkApplicationHistoryDto> list(Integer applicationId) {
        var histories = ubkApplicationHistoryRepository.findByApplicationIdOrderByCreatedDateDesc(applicationId);
        return ubkApplicationHistoryMapper.toDtoList(histories);
    }

}
