package kg.mlsp.ubk.model.integration;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

//Данные с ГКДО: ВОВ
//Сведения об участниках Великой Отечественной войны
@Data
@Entity
@Table(name = "ubk_great_patriotic_war_data")
public class UbkGreatPatrioticWarData extends UbkDataBase {
}
