package kg.mlsp.common.model.reference;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;


//Причины отказа в заявке

@Data
@Entity
@Table(name = "ref_rejection_reasons")
@EqualsAndHashCode(callSuper=false)
public class RefRejectionReason extends BaseRef {

    public static final int GMD_EXCEEDED = 1; // Превышение среднего дохода размера ГМД
    public static final int DOCUMENT_EXPIRED = 4; // Неправильные данные в документах(или документы истекшим сроком)
    public static final int DUPLICATE = 15; // Дубликат

}


//                    {1, new Guid("{B3493140-4E59-41D5-AAF7-98CD964D73E4}")},//крупный рогатый скот и яки
//        {2, new Guid("{72DB9124-9583-449F-8385-046F3B1E16CC}")},//лошади
//        {3, new Guid("{C75C6D34-462D-4B0D-AC44-120D67C33DC6}")},//мелко рогатый скот (овцы и козы)
//        {4, new Guid("{04E34A83-4707-4335-88F7-ACB0F9189F3E}")},//свиньи
//        {5, new Guid("{ABCB95C1-9399-470D-9DCB-B5CCE140B353}")},//домашние птицы
//        {6, new Guid("{193A46ED-64A3-4088-B469-5548182FFB46}")}//пчелы