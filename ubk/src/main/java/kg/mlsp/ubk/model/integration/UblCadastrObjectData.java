package kg.mlsp.ubk.model.integration;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;

//Данные Кадастра: Наличие недвижимости (по пин)

@Data
@Entity
@Table(name = "ubl_cadastr_object_data")
public class UblCadastrObjectData extends UbkDataBase {
}

