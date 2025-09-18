package kg.mlsp.common.model.reference;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

//Национальность

@Data
@Entity
@Table(name = "ref_nationalities")
@EqualsAndHashCode(callSuper=false)
public class RefNationality extends BaseRef {
}