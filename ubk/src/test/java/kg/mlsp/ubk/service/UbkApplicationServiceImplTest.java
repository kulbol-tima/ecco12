package kg.mlsp.ubk.service;

import ch.qos.logback.classic.Logger;
import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.read.ListAppender;
import kg.mlsp.common.exception.ApiException;
import kg.mlsp.ubk.dto.application.UbkApplicationCreateDto;
import kg.mlsp.ubk.mapper.UbkApplicationMapper;
import kg.mlsp.ubk.model.UbkApplication;
import kg.mlsp.ubk.repository.UbkApplicationRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.slf4j.LoggerFactory;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UbkApplicationServiceImplTest {

    @Mock
    private UbkApplicationRepository ubkApplicationRepository;

    @Mock
    private UbkApplicationMapper applicationMapper;

    @InjectMocks
    private UbkApplicationServiceImpl ubkApplicationService;

    private ListAppender<ILoggingEvent> listAppender;

    @BeforeEach
    void setUp() {
        Logger logger = (Logger) LoggerFactory.getLogger(UbkApplicationServiceImpl.class);
        listAppender = new ListAppender<>();
        listAppender.start();
        logger.addAppender(listAppender);
    }

    @Test
    void testUpdate_Success() {
        // Given
        Integer applicationId = 1;
        UbkApplicationCreateDto createDto = new UbkApplicationCreateDto();
        UbkApplication application = new UbkApplication();
        application.setId(applicationId);

        when(ubkApplicationRepository.findById(applicationId)).thenReturn(Optional.of(application));
        when(ubkApplicationRepository.save(any(UbkApplication.class))).thenReturn(application);

        // When
        ubkApplicationService.update(applicationId, createDto);

        // Then
        assertEquals(1, listAppender.list.size());
        ILoggingEvent loggingEvent = listAppender.list.get(0);
        assertEquals("Updated application with ID: 1", loggingEvent.getFormattedMessage());
    }

    @Test
    void testUpdate_NotFound() {
        // Given
        Integer applicationId = 1;
        UbkApplicationCreateDto createDto = new UbkApplicationCreateDto();

        when(ubkApplicationRepository.findById(applicationId)).thenReturn(Optional.empty());

        // When & Then
        assertThrows(ApiException.class, () -> ubkApplicationService.update(applicationId, createDto));
    }
}
