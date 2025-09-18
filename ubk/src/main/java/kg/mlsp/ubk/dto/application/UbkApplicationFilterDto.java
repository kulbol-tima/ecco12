package kg.mlsp.ubk.dto.application;

import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class UbkApplicationFilterDto {

    private Integer organizationId; //Организация
    private String registrationNumber; //Регистрационный номер
    private Integer requestTypeId; //Тип заявления
    private Integer statusId; //Статус заявления

    private LocalDate registrationDateStart; //Назначение с
    private LocalDate registrationDateEnd; //Назначение по

    private LocalDate assignedDateStart; //Назначение с
    private LocalDate assignedDateEnd; //Назначение по
    private BigDecimal amount; //Сумма назначения

    private Integer applicantId;
    private String applicantPin;
    private String firstName;
    private String secondName;
    private String middleName;
    private Integer genderId;
    private Integer documentSerialId;
    private String documentNumber;

}
