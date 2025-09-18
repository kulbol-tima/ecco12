package kg.mlsp.common.model.reference;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;

// Тип документа.

@Data
@Entity
@Table(name = "ref_document_types")
@EqualsAndHashCode(callSuper=false)
public class RefDocumentType extends BaseRef {
}