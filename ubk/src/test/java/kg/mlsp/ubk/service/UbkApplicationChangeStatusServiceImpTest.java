package kg.mlsp.ubk.service;

import kg.mlsp.common.model.RegPerson;
import kg.mlsp.common.model.reference.RefStatus;
import kg.mlsp.common.repository.PersonRepository;
import kg.mlsp.ubk.dto.ChangeStatusRequestDto;
import kg.mlsp.ubk.model.UbkApplication;
import kg.mlsp.ubk.repository.UbkApplicationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class UbkApplicationChangeStatusServiceImpTest {

    @Mock
    private UbkApplicationRepository ubkApplicationRepository;

    @Mock
    private UbkApplicationCheckService ubkApplicationCheckService;

    @Mock
    private UbkApplicationHistoryService ubkApplicationHistoryService;

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private UbkApplicationChangeStatusServiceImp ubkApplicationChangeStatusService;

    @Test
    void testChangeStatus_Success() {
        // Given
        Integer applicationId = 1;
        Integer newStatusId = 2;
        Integer oldStatusId = 1;

        UbkApplication application = new UbkApplication();
        application.setId(applicationId);
        application.setStatusId(oldStatusId);
        application.setApplicantId(1);

        RegPerson applicant = new RegPerson();
        applicant.setExpiredDate(LocalDate.now().plusDays(1));


        ChangeStatusRequestDto changeStatusDto = new ChangeStatusRequestDto();
        changeStatusDto.setStatusId(newStatusId);

        when(ubkApplicationRepository.findById(applicationId)).thenReturn(Optional.of(application));
        when(personRepository.findById(anyInt())).thenReturn(Optional.of(applicant));


        // When
        ubkApplicationChangeStatusService.changeStatus(applicationId, changeStatusDto);

        // Then
        ArgumentCaptor<UbkApplication> applicationCaptor = ArgumentCaptor.forClass(UbkApplication.class);
        verify(ubkApplicationRepository, times(1)).save(applicationCaptor.capture());
        UbkApplication savedApplication = applicationCaptor.getValue();
        assertEquals(newStatusId, savedApplication.getStatusId());

        ArgumentCaptor<ChangeStatusRequestDto> historyCaptor = ArgumentCaptor.forClass(ChangeStatusRequestDto.class);
        verify(ubkApplicationHistoryService).saveHistory(eq(applicationId), historyCaptor.capture());
        assertEquals(oldStatusId, historyCaptor.getValue().getOldStatusId());
    }
}
