package kg.mlsp.common.model.reference;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

// Тип продления заявки

@Data
@Entity
@Table(name = "ref_extension_types")
@EqualsAndHashCode(callSuper=false)
public class RefExtensionType extends BaseRef {
}