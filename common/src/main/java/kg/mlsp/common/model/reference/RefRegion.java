package kg.mlsp.common.model.reference;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;

// Регион,Область
@Data
@Entity
@Table(name = "ref_regions")
@EqualsAndHashCode(callSuper=false)
public class RefRegion extends BaseRef {

    @Column(name = "coefficient", nullable = false, precision = 10, scale = 2)
    @ColumnDefault("1.0")
    private BigDecimal coefficient; //Районный коэффициент

}