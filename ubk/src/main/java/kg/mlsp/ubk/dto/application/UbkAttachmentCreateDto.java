package kg.mlsp.ubk.dto.application;

import lombok.Data;

import java.util.UUID;
@Data
public class UbkAttachmentCreateDto {
    private UUID fileId;
    private String filePath;
    private Integer documentTypeId;
}
