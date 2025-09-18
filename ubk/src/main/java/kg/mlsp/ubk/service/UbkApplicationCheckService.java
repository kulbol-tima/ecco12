package kg.mlsp.ubk.service;

import kg.mlsp.ubk.dto.application.UbkApplicationDto;

public interface UbkApplicationCheckService {
    UbkApplicationDto duplicateCheck(Integer applicationId);
}
