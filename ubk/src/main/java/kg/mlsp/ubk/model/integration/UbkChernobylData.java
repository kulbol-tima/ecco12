package kg.mlsp.ubk.model.integration;

//Данные с ГКДО: ЧАЭС
//Сведения об участниках ликвидации последствий аварии на Чернобыльской АЭС

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "ubk_chernobyl_data")
public class UbkChernobylData extends UbkDataBase {
}
