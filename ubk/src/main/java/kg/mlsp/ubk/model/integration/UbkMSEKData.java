package kg.mlsp.ubk.model.integration;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;


//Данные из МСЭК
@Data
@Entity
@Table(name = "ubk_msek_data")
public class UbkMSEKData extends UbkDataBase {

}
