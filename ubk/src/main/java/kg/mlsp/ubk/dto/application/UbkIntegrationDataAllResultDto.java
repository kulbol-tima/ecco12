package kg.mlsp.ubk.dto.application;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class UbkIntegrationDataAllResultDto {
    private LocalDateTime requestStartDate;
    private LocalDateTime requestEndDate;
    private Boolean msecDataSuccess;
    private Boolean passportDataSuccess;
    private Boolean zagsDataSuccess;
    private Boolean factAddressDataSuccess;
    private Boolean pensionDataSuccess;
    private Boolean employmentPeriodDataSuccess;
    private Boolean individualEntrepreneurDataSuccess;
    private Boolean patentDataSuccess;
    private Boolean cadastrObjectDataSuccess;
}
