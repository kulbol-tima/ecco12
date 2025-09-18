package kg.mlsp.ubk.service;

import kg.mlsp.common.exception.ApiException;
import kg.mlsp.common.exception.ErrorCode;
import kg.mlsp.common.exception.ErrorMessage;
import kg.mlsp.common.exception.SuccessMessage;
import kg.mlsp.ubk.dto.income.UbkApplicationIncomeCreateDto;
import kg.mlsp.ubk.dto.income.UbkApplicationIncomeDto;
import kg.mlsp.ubk.mapper.UbkApplicationIncomeMapper;
import kg.mlsp.ubk.model.UbkApplicationIncome;
import kg.mlsp.ubk.repository.UbkApplicationIncomeRepository;
import kg.mlsp.ubk.repository.UbkApplicationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UbkApplicationIncomeServiceImp implements UbkApplicationIncomeService {

    private final UbkApplicationIncomeMapper applicationIncomeMapper;
    private final UbkApplicationRepository ubkApplicationRepository;
    private final UbkApplicationIncomeRepository ubkApplicationIncomeRepository;

    @Override
    public UbkApplicationIncomeDto create(Integer applicationId, UbkApplicationIncomeCreateDto createDto) {

        var application = ubkApplicationRepository.findById(applicationId)
                .orElseThrow(() -> new ApiException(ErrorCode.NOT_FOUND,
                        String.format(ErrorMessage.APPLICATION_NOT_FOUND, applicationId)));

        var income = new UbkApplicationIncome();
        income.setApplication(application);
        income.setPersonId(createDto.getPersonId());
        income.setIncomeTypeId(createDto.getIncomeTypeId());
        income.setAmount(createDto.getAmount());
        income.setEmploymentTypeId(createDto.getEmploymentTypeId());

        income = ubkApplicationIncomeRepository.save(income);

        log.info("Created family member for application with ID: {}", applicationId);

        return applicationIncomeMapper.toDto(income);
    }

    @Override
    public UbkApplicationIncomeDto update(Integer id, UbkApplicationIncomeCreateDto createDto) {

        var income = ubkApplicationIncomeRepository.findById(id)
                .orElseThrow(() -> new ApiException(ErrorCode.NOT_FOUND,  String.format(ErrorMessage.INCOME_NOT_FOUND, id)));

        income.setPersonId(createDto.getPersonId());
        income.setIncomeTypeId(createDto.getIncomeTypeId());
        income.setAmount(createDto.getAmount());
        income.setEmploymentTypeId(createDto.getEmploymentTypeId());

        income = ubkApplicationIncomeRepository.save(income);

        log.info("Created family member for application with ID: {}", id);

        return applicationIncomeMapper.toDto(income);
    }

    @Override
    public UbkApplicationIncomeDto getById(Integer id) {
        var income = ubkApplicationIncomeRepository.findById(id)
                .orElseThrow(() -> new ApiException(ErrorCode.NOT_FOUND, String.format(ErrorMessage.INCOME_NOT_FOUND, id)));

        return applicationIncomeMapper.toDto(income);
    }

    @Override
    public List<UbkApplicationIncomeDto> list(Integer applicationId) {
        var application = ubkApplicationRepository.findById(applicationId)
                .orElseThrow(() -> new ApiException(ErrorCode.NOT_FOUND, String.format(ErrorMessage.APPLICATION_NOT_FOUND, applicationId)));

        var incomeList = ubkApplicationIncomeRepository.findByApplicationId(application.getId());

        return applicationIncomeMapper.toDtoList(incomeList);
    }

    @Override
    public String delete(Integer id) {
        var income = ubkApplicationIncomeRepository.findById(id).orElseThrow(
                () -> new ApiException(ErrorCode.NOT_FOUND, String.format(ErrorMessage.INCOME_NOT_FOUND, id)));

        income.markAsDeleted();
        ubkApplicationIncomeRepository.save(income);

        return SuccessMessage.RECORD_DELETED;
    }
}
