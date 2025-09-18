package kg.mlsp.common.model.reference;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Arrays;
import java.util.List;

// Статус заявки
@Data
@Entity
@Table(name = "ref_statuses")
@EqualsAndHashCode(callSuper=false)
public class RefStatus extends BaseRef {
    public static final int DRAFT = 1; // Черновик
    public static final int NEW_REGISTERED = 2; // Новая зарегистрированная
    public static final int REJECTED = 3; // Отклонена

    // Активные статусы для УБК (для проверки дублирования заявок)
    public static final List<Integer> UBK_ACTIVE_STATUSES = Arrays.asList(
            DRAFT, NEW_REGISTERED
    );

}