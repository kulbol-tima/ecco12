package kg.mlsp.ubk.service;

import kg.mlsp.common.model.reference.RefStatus;
import kg.mlsp.ubk.dto.application.UbkApplicationDto;
import kg.mlsp.ubk.mapper.UbkApplicationMapper;
import kg.mlsp.ubk.model.UbkApplication;
import kg.mlsp.ubk.repository.UbkApplicationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.PageRequest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UbkApplicationCheckServiceImpTest {

    @Mock
    private UbkApplicationRepository ubkApplicationRepository;

    @Mock
    private UbkApplicationMapper ubkApplicationMapper;

    @InjectMocks
    private UbkApplicationCheckServiceImp ubkApplicationCheckService;

    @Test
    void testDuplicateCheck_Found() {
        // Given
        Integer applicationId = 1;
        String applicantPin = "12345678901234";

        UbkApplication application = new UbkApplication();
        application.setId(applicationId);
        application.setApplicantId(1);
        application.setApplicantPin(applicantPin);

        UbkApplication duplicateApplication = new UbkApplication();
        duplicateApplication.setId(2);
        duplicateApplication.setApplicantPin(applicantPin);

        when(ubkApplicationRepository.findById(applicationId)).thenReturn(Optional.of(application));
        when(ubkApplicationRepository.findActiveDuplicates(
                eq(applicantPin),
                eq(applicationId),
                any(Iterable.class),
                any(PageRequest.class)
        )).thenReturn(List.of(duplicateApplication));
        when(ubkApplicationMapper.toDto(duplicateApplication)).thenReturn(new UbkApplicationDto());

        // When
        UbkApplicationDto result = ubkApplicationCheckService.duplicateCheck(applicationId);

        // Then
        assertNotNull(result);
    }

    @Test
    void testDuplicateCheck_NotFound() {
        // Given
        Integer applicationId = 1;
        String applicantPin = "12345678901234";

        UbkApplication application = new UbkApplication();
        application.setId(applicationId);
        application.setApplicantId(1);
        application.setApplicantPin(applicantPin);

        when(ubkApplicationRepository.findById(applicationId)).thenReturn(Optional.of(application));
        when(ubkApplicationRepository.findActiveDuplicates(
                eq(applicantPin),
                eq(applicationId),
                any(Iterable.class),
                any(PageRequest.class)
        )).thenReturn(List.of());

        // When
        UbkApplicationDto result = ubkApplicationCheckService.duplicateCheck(applicationId);

        // Then
        assertNull(result);
    }
}
