package kg.mlsp.common.model.reference;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "ref_marital_statuses")
@EqualsAndHashCode(callSuper=false)
public class RefMaritalStatus extends BaseRef {

//        {"0", marriedFStatusId},
//        {"1", singleFStatusId},
//        {"3", widowFStatusId},
//        {"2", divorcedFStatusId}


}
