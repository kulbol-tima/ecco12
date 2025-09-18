package kg.mlsp.common.model.reference;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;


//Вид дохода
@Data
@Entity
@Table(name = "ref_income_types")
@EqualsAndHashCode(callSuper=false)
public class RefIncomeType extends BaseRef {
}