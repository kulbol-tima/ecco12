package kg.mlsp.common.model.reference;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.math.BigDecimal;

// Район
@Data
@Entity
@Table(name = "ref_districts")
@EqualsAndHashCode(callSuper=false)
@EntityListeners(AuditingEntityListener.class)
public class RefDistrict extends BaseRef {

    //Область, регион
    @ManyToOne
    @JoinColumn(name = "region_id", referencedColumnName = "id")
    private RefRegion region;

    @Column(name = "coefficient", nullable = false, precision = 10, scale = 2)
    @ColumnDefault("1.0")
    private BigDecimal coefficient; //Районный коэффициент

    @Column(name = "region_id", insertable = false, updatable = false)
    private Integer regionId;

    public Integer getRegionId() {
        return region != null ? region.getId() : regionId;
    }
}