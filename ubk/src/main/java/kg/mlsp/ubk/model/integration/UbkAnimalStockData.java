package kg.mlsp.ubk.model.integration;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;


//Ветеринария: Информация о КРС, МРС
@Data
@Entity
@Table(name = "ubk_animal_stock_data")
public class UbkAnimalStockData extends UbkDataBase {

}
