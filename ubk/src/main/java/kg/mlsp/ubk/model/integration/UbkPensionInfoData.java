package kg.mlsp.ubk.model.integration;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;


//Данные из СФ: Наличие пенсии
@Data
@Entity
@Table(name = "ubk_pension_info_data")
public class UbkPensionInfoData extends UbkDataBase {
}
