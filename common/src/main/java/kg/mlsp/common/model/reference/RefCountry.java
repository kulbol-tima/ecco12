package kg.mlsp.common.model.reference;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

// Страна, Гражданство
@Data
@Entity
@Table(name = "ref_countries")
@EqualsAndHashCode(callSuper=false)
public class RefCountry extends BaseRef {
}