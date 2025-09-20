package kg.mlsp.ubk.service;

import kg.mlsp.common.exception.ApiException;
import kg.mlsp.common.exception.ErrorCode;
import kg.mlsp.common.exception.ErrorMessage;
import kg.mlsp.ubk.repository.UbkApplicationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Slf4j
@Service
@RequiredArgsConstructor
public class UbkCalculateGMDServiceImp implements UbkCalculateGMDService {

    private final UbkApplicationRepository applicationRepository;

    @Override
    public BigDecimal calculateGMD(Integer applicationId) {
        var application = applicationRepository.findById(applicationId).orElseThrow(()
                -> new ApiException(ErrorCode.NOT_FOUND, String.format(ErrorMessage.APPLICATION_NOT_FOUND, applicationId)));

        var incomes = application.getIncomes();
        var members = application.getFamilyMembers();

        var totalIncome = incomes.stream()
                .map(income -> income.getAmount() != null ? income.getAmount() : BigDecimal.ZERO)
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        if (members != null && !members.isEmpty()) {
            return totalIncome.divide(new BigDecimal(members.size()), 2, BigDecimal.ROUND_HALF_UP);
        }

        return BigDecimal.ZERO;
    }
}
