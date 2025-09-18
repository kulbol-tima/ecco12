package kg.mlsp.ubk.model.integration;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;


//Данные из ГНС: Информация о наличии патента
@Data
@Entity
@Table(name = "ubk_patent_info_data")
public class UbkPatentInfoData extends UbkDataBase {
}
