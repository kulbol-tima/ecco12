package kg.mlsp.ubk.service.payment;

import kg.mlsp.common.model.reference.RefBank;
import kg.mlsp.common.repository.reference.RefBankRepository;
import kg.mlsp.ubk.dto.payment.UbkBankRequisitesCreateDto;
import kg.mlsp.ubk.dto.payment.UbkBankRequisitesDto;
import kg.mlsp.ubk.mapper.payment.UbkBankRequisitesMapper;
import kg.mlsp.ubk.model.UbkApplication;
import kg.mlsp.ubk.model.payment.UbkBankRequisites;
import kg.mlsp.ubk.repository.UbkApplicationRepository;
import kg.mlsp.ubk.repository.UbkBankRequisitesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UbkBankRequisitesServiceImp implements UbkBankRequisitesService {

    private final RefBankRepository refBankRepository;
    private final UbkApplicationRepository ubkApplicationRepository;
    private final UbkBankRequisitesRepository bankRequisitesRepository;
    private final UbkBankRequisitesMapper ubkBankRequisitesMapper;


    @Override
    public UbkBankRequisitesDto create(Integer applicationId, UbkBankRequisitesCreateDto createDto) {
        checkDataIsValid(createDto);
        UbkApplication application = getApplication(applicationId);

        UbkBankRequisites bankRequisites = new UbkBankRequisites();
        bankRequisites.setApplication(application);
        bankRequisites.setBankId(createDto.getBankId());
        bankRequisites.setAccountNumber(createDto.getAccountNumber());
        bankRequisites.setIsActive(createDto.getIsActive());

        bankRequisitesRepository.save(bankRequisites);

        return ubkBankRequisitesMapper.toDto(bankRequisites);
    }

    @Override
    public UbkBankRequisitesDto update(Integer id, UbkBankRequisitesCreateDto createDto) {
        checkDataIsValid(createDto);

        UbkBankRequisites bankRequisites = bankRequisitesRepository.findById(id).orElse(null);
        if(bankRequisites == null){
            throw new RuntimeException("Bank requisites not found");
        }
        bankRequisites.setBankId(createDto.getBankId());
        bankRequisites.setAccountNumber(createDto.getAccountNumber());
        bankRequisites.setIsActive(createDto.getIsActive());

        bankRequisitesRepository.save(bankRequisites);

        return ubkBankRequisitesMapper.toDto(bankRequisites);
    }

    @Override
    public UbkBankRequisitesDto getById(Integer id) {
        UbkBankRequisites bankRequisites = bankRequisitesRepository.findById(id).orElse(null);
        if(bankRequisites == null){
            throw new RuntimeException("Bank requisites not found");
        }
        return ubkBankRequisitesMapper.toDto(bankRequisites);
    }

    @Override
    public List<UbkBankRequisitesDto> list(Integer applicationId) {
        List<UbkBankRequisites> list = bankRequisitesRepository.findByApplicationId(applicationId);
        return ubkBankRequisitesMapper.toDtoList(list);
    }

    @Override
    public String delete(Integer id) {

        UbkBankRequisites bankRequisites = bankRequisitesRepository.findById(id).orElse(null);
        if(bankRequisites == null){
            throw new RuntimeException("Bank requisites not found");
        }
        bankRequisites.markAsDeleted();
        bankRequisitesRepository.save(bankRequisites);
        return "Реквизиты удалены";
    }

    private void checkDataIsValid(UbkBankRequisitesCreateDto createDto){
        if(createDto.getBankId() == null){
            throw new RuntimeException("Банк не выбран");
        }
        if(createDto.getAccountNumber() == null || createDto.getAccountNumber().isEmpty()){
            throw new RuntimeException("Номер счета не заполнен");
        }

        RefBank bank = refBankRepository.findById(createDto.getBankId()).orElse(null);
        if(bank == null){
            throw new RuntimeException("Банк не найден");
        }
    }

    private UbkApplication getApplication(Integer applicationId){

        UbkApplication application = ubkApplicationRepository.findById(applicationId).orElse(null);

        if(application == null){
            throw new RuntimeException("Application not found");
        }

        return  application;
    }




}
