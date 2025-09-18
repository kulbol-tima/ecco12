package kg.mlsp.ubk.model.integration;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;


//Данные из ИСРТ: Статус занятости
@Data
@Entity
@Table(name = "ubk_employment_status_data")
public class UbkEmploymentStatusData extends  UbkDataBase {
}
