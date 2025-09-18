package kg.mlsp.esp.model;

import jakarta.persistence.*;
import kg.mlsp.common.model.BaseAuditableEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Data
@EqualsAndHashCode(callSuper = true)
@Table(name = "esp_applications")
public class EspApplication extends BaseAuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


}
