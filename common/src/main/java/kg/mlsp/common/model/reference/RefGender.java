package kg.mlsp.common.model.reference;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "ref_genders")
@EqualsAndHashCode(callSuper=false)
public class RefGender extends BaseRef {
    public static final int FEMALE = 1;
    public static final int MALE = 2;
}