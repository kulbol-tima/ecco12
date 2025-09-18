package kg.mlsp.ubk.service;

import kg.mlsp.ubk.dto.ChangeStatusRequestDto;
import kg.mlsp.ubk.dto.application.UbkApplicationHistoryDto;

import java.util.List;

public interface UbkApplicationHistoryService {
    void saveHistory(Integer applicationId, ChangeStatusRequestDto changeStatusDto);
    List<UbkApplicationHistoryDto> list(Integer applicationId);
}
