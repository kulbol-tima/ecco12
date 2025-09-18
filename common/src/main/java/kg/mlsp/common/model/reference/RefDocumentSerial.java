package kg.mlsp.common.model.reference;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@Entity
@Table(name = "ref_passport_serials")
@EqualsAndHashCode(callSuper=false)
public class RefDocumentSerial extends BaseRef {
}