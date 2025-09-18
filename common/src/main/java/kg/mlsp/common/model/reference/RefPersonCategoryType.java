package kg.mlsp.common.model.reference;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

// Категории (Категория отсутствуе, Общий, Инвалид ВОВ 1 группы ...)

@Data
@Entity
@Table(name = "ref_person_category_types")
@EqualsAndHashCode(callSuper=false)
public class RefPersonCategoryType extends BaseRef {
}