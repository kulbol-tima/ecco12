package kg.mlsp.ubk.service.payment;


import kg.mlsp.common.model.RegPerson;
import kg.mlsp.common.model.reference.RefRelationshipType;
import kg.mlsp.common.repository.PersonRepository;
import kg.mlsp.ubk.constants.UbkPaymentConst;
import kg.mlsp.ubk.dto.payment.UbkPaymentAssignmentCreateDto;
import kg.mlsp.ubk.model.UbkApplication;
import kg.mlsp.ubk.model.UbkApplicationFamilyMember;
import kg.mlsp.ubk.model.payment.UbkPaymentAssignment;
import kg.mlsp.ubk.model.payment.UbkPaymentAssignmentMember;
import kg.mlsp.ubk.repository.UbkApplicationRepository;
import kg.mlsp.ubk.repository.UbkPaymentAssignmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

//Расчет и назначение уй-булоого комок

@Slf4j
@Service
@RequiredArgsConstructor
public class UbkPaymentAssignmentServiceImp implements UbkPaymentAssignmentService {

    private final PersonRepository personRepository;

    private final UbkApplicationRepository ubkApplicationRepository;
    private final UbkPaymentAssignmentRepository ubkPaymentAssignmentRepository;


    @Override
    public UbkPaymentAssignment create(Integer applicationId, UbkPaymentAssignmentCreateDto createDto){

        validateCreateDto(applicationId, createDto);

        var application = getApplication(applicationId);
        assert application != null;

        double paymentAmount = calcPaymentAmount(application);
        int memberCount = calcFamilyMemberCount(application);

        if(memberCount == 0){
            error("Члены семьи не пустые!");
        }

        var avgIncome = paymentAmount / memberCount;

        if(avgIncome >= UbkPaymentConst.SMI){
            error("Среднедушевой доход семьи превышает ГМД. ЕПМС не положено! Доход:  " + avgIncome);
        }

        var children  = getListForPayment(application);

        if(children.isEmpty()){
            error("Нет членов семьи, на которых можно назначить ЕПМС");
        }
        var underWardCount = 0;
        var twinsCount = 0;
        var tripletsCount = 0;

        for(UbkApplicationFamilyMember familyMember : application.getFamilyMembers()){
            if(Objects.equals(familyMember.getRelationshipTypeId(), RefRelationshipType.UNDER_WARD)){
                underWardCount++;
            } else if(Objects.equals(familyMember.getRelationshipTypeId(), RefRelationshipType.TWINS)){
                twinsCount++;
            } else if(Objects.equals(familyMember.getRelationshipTypeId(), RefRelationshipType.TRIPLETS)){
                tripletsCount++;
            }
        }

        if(twinsCount % 2 != 0){
            error("Проверьте количество двойняшек!");
        }
        if(tripletsCount != 0 && tripletsCount < 3 ){
            error("Проверьте количество тройняшек!");
        }

        UbkPaymentAssignment assignment = new UbkPaymentAssignment();
        assignment.setAssignedDate(LocalDateTime.now());
        assignment.setStartDate(createDto.getStartDate());
        assignment.setEndDate(createDto.getEndDate());
        assignment.setAverageIncome(BigDecimal.valueOf(avgIncome));
        assignment.setFamilyMemberCount(memberCount);
        assignment.setDependentsCount(children.size());
        assignment.setUnderWardCount(underWardCount);
        assignment.setTwinsCount(twinsCount);
        assignment.setTripletsCount(tripletsCount);
        assignment.setIsActive(true);
        ubkPaymentAssignmentRepository.save(assignment);

        for (UbkApplicationFamilyMember familyMember : children) {
            var assignmentMember = new UbkPaymentAssignmentMember();
            assignmentMember.setFamilyMember(familyMember);
            assignmentMember.setAssignment(assignment);
            assignmentMember.setAmount(BigDecimal.valueOf(UbkPaymentConst.PAYMENT_PER_CHILD));
            assignmentMember.setCoefficient(BigDecimal.valueOf(1.0));
            assignmentMember.setBorderCoefficient(BigDecimal.valueOf(1.0));
            assignment.getAssignmentMembers().add(assignmentMember);
        }
        assignment.setAmount(BigDecimal.valueOf(UbkPaymentConst.PAYMENT_PER_CHILD * children.size()));
        ubkPaymentAssignmentRepository.save(assignment);

        return assignment;
    }

    private UbkApplication getApplication(Integer applicationId){
        var application  = ubkApplicationRepository.findById(applicationId).orElse(null);
        if(application == null){
            error("Заявление с id " + applicationId + " не найдено");
            return null;
        }
        return application;
    }

    private List<UbkApplicationFamilyMember> getListForPayment(UbkApplication application){

        List<UbkApplicationFamilyMember> result = new ArrayList<>();

        for (UbkApplicationFamilyMember familyMember : application.getFamilyMembers()) {
            RegPerson person = personRepository.findById(application.getApplicantId()).orElse(null);

            if(person == null){
                error("Член семьи с id " + familyMember.getFamilyMemberId() + " не найден");
            }
            assert person != null;
            if(person.getAge() != null && person.getAge() < 17){
                result.add(familyMember);
            }
        }

        return result;
    }


    private double calcPaymentAmount(UbkApplication application){

        return application.getIncomes().stream()
                .mapToDouble(income -> income.getAmount().doubleValue())
                .sum();
    }

    private Integer calcFamilyMemberCount(UbkApplication application){
        //Изменить на получение количества членов семьи из заявления
        return  application.getFamilyMembers().size();
    }


    private void validateCreateDto(Integer applicationId, UbkPaymentAssignmentCreateDto createDto){
        if (createDto.getStartDate() == null){
            error("Дата начала назначения платежа не может быть пустой");
        }
        if (createDto.getEndDate() == null){
            error("Дата окончания назначения платежа не может быть пустой");
        }
        if (createDto.getEndDate().isBefore(createDto.getStartDate())){
            error("Дата окончания назначения платежа не может быть раньше даты начала");
        }
        var existingAssignment = ubkPaymentAssignmentRepository.findByApplicationId(applicationId);
        if (existingAssignment != null){
            error("Платежное назначение для данного заявления уже существует");
        }
    }



    private void error(String message){
        log.error(message);
        throw new RuntimeException(message);
    }

}
