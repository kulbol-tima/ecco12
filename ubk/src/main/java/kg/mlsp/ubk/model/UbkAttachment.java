package kg.mlsp.ubk.model;

import jakarta.persistence.*;
import kg.mlsp.common.model.BaseAuditableEntity;
import lombok.Data;
import org.hibernate.annotations.Where;

import java.util.UUID;


@Data
@Entity
@Table(name = "ubk_attachments")
@Where(clause = "deleted = false")
public class UbkAttachment extends BaseAuditableEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "file_id", nullable = false, unique = true) //Идентификатор файла в файловом хранилище
    private UUID fileId;

    @Column(name = "file_path", nullable = false) //Путь к файлу в файловом хранилище
    private String filePath;

    @ManyToOne
    @JoinColumn(name = "application_id", referencedColumnName = "id", nullable = false)
    private UbkApplication application;

    @Column(name = "document_type_id") //Тип документа
    private Integer documentTypeId; //RefPersonDocumentType

}
