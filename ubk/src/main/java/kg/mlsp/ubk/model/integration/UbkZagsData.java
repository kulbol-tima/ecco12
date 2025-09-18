package kg.mlsp.ubk.model.integration;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;


//Данные из ГРС: ЗАГС база
@Data
@Entity
@Table(name = "ubk_zags_data")
public class UbkZagsData extends UbkDataBase {
}
