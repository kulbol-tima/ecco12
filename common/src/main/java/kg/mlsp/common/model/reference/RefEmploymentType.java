package kg.mlsp.common.model.reference;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

//Род занятий заявителя

@Data
@Entity
@Table(name = "ref_employment_types")
@EqualsAndHashCode(callSuper=false)
public class RefEmploymentType extends BaseRef {

    public static final int CHILD_UNDER_3 = 17; // До 3 лет code 16
    public static final int CHILD_3_16 = 18; // 3-16 лет code 17


}