package kg.mlsp.common.model.reference;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

//Тип заявления Первичное или Повторное

@Data
@Entity
@Table(name = "ref_app_request_types")
@EqualsAndHashCode(callSuper=false)
public class RefAppRequestType extends BaseRef {
}