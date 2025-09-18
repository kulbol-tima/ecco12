package kg.mlsp.ubk.model.integration;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;


//Данные из ГНС: ИП
@Data
@Entity
@Table(name = "ubk_individual_entrepreneur_data")
public class UbkIndividualEntrepreneurData extends UbkDataBase {

}
