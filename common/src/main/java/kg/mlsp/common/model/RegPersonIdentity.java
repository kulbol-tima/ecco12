package kg.mlsp.common.model;

import jakarta.persistence.*;
import kg.mlsp.common.converter.CryptoConverter;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "reg_person_identities")
@EqualsAndHashCode(callSuper=false)
public class RegPersonIdentity extends BaseAuditableEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "pin", nullable = false, unique = true)
    @Convert(converter = CryptoConverter.class)
    private String pin;

    @Column(name = "is_dead")
    private Boolean isDead = false;

}