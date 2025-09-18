package kg.mlsp.common.model.reference;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


// Айыл аймак, айыл окмоту
@Data
@Entity
@Table(name = "ref_ayil_aimaks")
@EqualsAndHashCode(callSuper=false)
@EntityListeners(AuditingEntityListener.class)
public class RefAyilAimak extends BaseRef {

    //Район
    @ManyToOne
    @JoinColumn(name = "district_id", referencedColumnName = "id")
    private RefDistrict district;


    @Column(name = "district_id", insertable = false, updatable = false)
    private Integer districtId;

    public Integer getDistrictId() {
        return district != null ? district.getId() : districtId;
    }

}
