package kg.mlsp.common.model.reference;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

// Банк

@Data
@Entity
@Table(name = "ref_banks")
@EqualsAndHashCode(callSuper=false)
public class RefBank extends BaseRef {
}