package kg.mlsp.common.model.reference;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

// Тип документа.

@Data
@Entity
@Table(name = "ref_person_document_types")
@EqualsAndHashCode(callSuper=false)
public class RefPersonDocumentType extends BaseRef {
}