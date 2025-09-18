package kg.mlsp.ubk.dto.application;

import kg.mlsp.common.dto.reference.RefGeneralDto;
import lombok.Data;

import java.util.UUID;

@Data
public class UbkAttachmentDto {
    private Integer id;
    private UUID fileId;
    private String filePath;
    private Integer documentTypeId;
    private RefGeneralDto documentType;
}
