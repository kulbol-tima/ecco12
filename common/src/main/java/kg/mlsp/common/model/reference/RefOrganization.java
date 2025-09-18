package kg.mlsp.common.model.reference;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

// Организация
@Data
@Entity
@Table(name = "ref_organizations")
@EqualsAndHashCode(callSuper=false)
public class RefOrganization extends BaseRef {
}