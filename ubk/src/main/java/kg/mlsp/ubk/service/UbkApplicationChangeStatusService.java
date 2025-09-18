package kg.mlsp.ubk.service;

import kg.mlsp.ubk.dto.ChangeStatusRequestDto;

public interface UbkApplicationChangeStatusService {

    String changeStatus(Integer applicationId, ChangeStatusRequestDto changeStatusDto);

}
