package kg.mlsp.ubk.model.integration;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

//Данные из СФ: Информация о периодах работы застрахованного лица

@Data
@Entity
@Table(name = "ubk_employment_period_data")
public class UbkEmploymentPeriodData extends UbkDataBase {
}
