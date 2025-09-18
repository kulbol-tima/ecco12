package kg.mlsp.ubk.model.integration;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

//Данные ГКДО: Афганцы
//Сведения об участниках боевых действий на территории других государств
@Data
@Entity
@Table(name = "ubk_foreign_veteran_data")
public class UbkForeignVeteranData extends UbkDataBase {
}

