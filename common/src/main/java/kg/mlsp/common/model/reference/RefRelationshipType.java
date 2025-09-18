package kg.mlsp.common.model.reference;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

//Родственные отношения

@Data
@Entity
@Table(name = "ref_relationship_types")
@EqualsAndHashCode(callSuper=false)
public class RefRelationshipType extends BaseRef {

    public static final Integer UNDER_WARD = 8; //Опекаемый
    public static final Integer TWINS = 9; //Двойня
    public static final Integer TRIPLETS = 10; //Тройня и более

}