package kg.mlsp.ubk.model.integration;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;


//Данные из ГРС: Паспортная база
@Data
@Entity
@Table(name = "ubk_passport_data")
public class UbkPassportData extends UbkDataBase {

}
