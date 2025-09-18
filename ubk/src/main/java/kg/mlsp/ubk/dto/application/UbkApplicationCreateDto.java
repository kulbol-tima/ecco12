package kg.mlsp.ubk.dto.application;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UbkApplicationCreateDto{

    private Integer organizationId;
    private Integer requestTypeId;

    @NotNull(message = "Заявитель не может быть пустым")
    private Integer applicantId;

    @NotNull(message = "Род занятий не может быть пустым")
    private Integer employmentTypeId;

    @NotNull(message = "Категория заявителя не может быть пустой")
    private Integer personCategoryId;

    private String phone; //Телефон
    private String email; //Электронная почта
    private String reason; //Причина обращения
    private String comment; //Комментарий
    private Integer attachmentsCount; //Кол-во приложенных документов

    @NotNull(message = "Дата регистрации не может быть пустой")
    @PastOrPresent(message = "Дата регистрации не может быть в будущем")
    private LocalDate registrationDate;

}
