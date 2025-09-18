package kg.mlsp.ubk.model.integration;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;


//Данные из ГРС: Сведения о транспортных средствах
@Data
@Entity
@Table(name = "ubk_transport_data")
public class UbkTransportData extends UbkDataBase {

}
