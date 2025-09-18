package kg.mlsp.ubk.model.integration;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;


//Данные из ГРС: Адрес фактического места жительства (АСБ)
@Data
@Entity
@Table(name = "ubk_fact_address_data")
public class UbkFactAddressData extends UbkDataBase {
}
