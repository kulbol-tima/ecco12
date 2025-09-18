package kg.mlsp.common.model.reference;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.ColumnDefault;

import java.math.BigDecimal;

// Айыл, село, населенный пункт

@Data
@Entity
@Table(name = "ref_villages")
@EqualsAndHashCode(callSuper=false)
public class RefVillage extends BaseRef {

    //Айыл аймак
    @ManyToOne
    @JoinColumn(name = "ayil_aimak_id", referencedColumnName = "id")
    private RefAyilAimak ayilAimak;

    //Районный коэффициент
    @Column(name = "coefficient", nullable = false, precision = 10, scale = 2)
    @ColumnDefault("1.0")
    private BigDecimal coefficient;

    // Коэффициент приграничной зоны
    @Column(name = "border_coefficient", nullable = false, precision = 10, scale = 2)
    @ColumnDefault("1.0")
    private BigDecimal borderCoefficient;

    // Высота над уровнем моря (в метрах)
    @Column(name = "altitude")
    private Integer altitude;

    @Column(name = "ayil_aimak_id", insertable = false, updatable = false)
    private Integer ayilAimakId;

    public Integer getAyilAimak() {
        return ayilAimak != null ? ayilAimak.getId() : ayilAimakId;
    }

}