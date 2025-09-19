package kg.mlsp.ubk.service;

import kg.mlsp.ubk.model.UbkApplication;
import kg.mlsp.ubk.model.UbkApplicationFamilyMember;
import kg.mlsp.ubk.model.UbkApplicationIncome;
import kg.mlsp.ubk.repository.UbkApplicationRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class UbkCalculateGMDServiceImpTest {

    @Mock
    private UbkApplicationRepository applicationRepository;

    @InjectMocks
    private UbkCalculateGMDServiceImp ubkCalculateGMDService;

    @Test
    void testCalculateGMD_Success() {
        // Given
        Integer applicationId = 1;
        UbkApplication application = new UbkApplication();
        application.setId(applicationId);

        UbkApplicationIncome income1 = new UbkApplicationIncome();
        income1.setAmount(new BigDecimal("1000.50"));
        UbkApplicationIncome income2 = new UbkApplicationIncome();
        income2.setAmount(new BigDecimal("500.25"));
        application.setIncomes(List.of(income1, income2));

        UbkApplicationFamilyMember member1 = new UbkApplicationFamilyMember();
        UbkApplicationFamilyMember member2 = new UbkApplicationFamilyMember();
        application.setFamilyMembers(List.of(member1, member2));

        when(applicationRepository.findById(applicationId)).thenReturn(Optional.of(application));

        // When
        BigDecimal gmd = ubkCalculateGMDService.calculateGMD(applicationId);

        // Then
        assertTrue(new BigDecimal("750.38").compareTo(gmd) == 0);
    }

    @Test
    void testCalculateGMD_NoFamilyMembers() {
        // Given
        Integer applicationId = 1;
        UbkApplication application = new UbkApplication();
        application.setId(applicationId);

        UbkApplicationIncome income1 = new UbkApplicationIncome();
        income1.setAmount(new BigDecimal("1000.50"));
        application.setIncomes(List.of(income1));

        application.setFamilyMembers(Collections.emptyList());

        when(applicationRepository.findById(applicationId)).thenReturn(Optional.of(application));

        // When
        BigDecimal gmd = ubkCalculateGMDService.calculateGMD(applicationId);

        // Then
        assertTrue(BigDecimal.ZERO.compareTo(gmd) == 0);
    }

    @Test
    void testCalculateGMD_NoIncomes() {
        // Given
        Integer applicationId = 1;
        UbkApplication application = new UbkApplication();
        application.setId(applicationId);

        application.setIncomes(Collections.emptyList());

        UbkApplicationFamilyMember member1 = new UbkApplicationFamilyMember();
        application.setFamilyMembers(List.of(member1));

        when(applicationRepository.findById(applicationId)).thenReturn(Optional.of(application));

        // When
        BigDecimal gmd = ubkCalculateGMDService.calculateGMD(applicationId);

        // Then
        assertTrue(BigDecimal.ZERO.compareTo(gmd) == 0);
    }

    @Test
    void testCalculateGMD_NullIncome() {
        // Given
        Integer applicationId = 1;
        UbkApplication application = new UbkApplication();
        application.setId(applicationId);

        UbkApplicationIncome income1 = new UbkApplicationIncome();
        income1.setAmount(new BigDecimal("1000.50"));
        UbkApplicationIncome income2 = new UbkApplicationIncome();
        income2.setAmount(null);
        application.setIncomes(List.of(income1, income2));

        UbkApplicationFamilyMember member1 = new UbkApplicationFamilyMember();
        application.setFamilyMembers(List.of(member1));

        when(applicationRepository.findById(applicationId)).thenReturn(Optional.of(application));

        // When
        BigDecimal gmd = ubkCalculateGMDService.calculateGMD(applicationId);

        // Then
        assertTrue(new BigDecimal("1000.50").compareTo(gmd) == 0);
    }
}
