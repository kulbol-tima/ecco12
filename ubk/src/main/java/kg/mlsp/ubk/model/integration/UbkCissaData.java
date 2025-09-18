package kg.mlsp.ubk.model.integration;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;


//Данные из КИССП
//Другие услуги (выплаты и пособия, которые идут параллельно, включая кресло, коляски и другие)

@Data
@Entity
@Table(name = "ubk_cissa_data")
public class UbkCissaData extends UbkDataBase {

}
