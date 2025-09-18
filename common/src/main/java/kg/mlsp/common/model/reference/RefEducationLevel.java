package kg.mlsp.common.model.reference;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

//Образование

@Data
@Entity
@Table(name = "ref_education_levels")
@EqualsAndHashCode(callSuper=false)
public class RefEducationLevel extends BaseRef {
}