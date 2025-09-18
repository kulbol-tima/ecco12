package kg.mlsp.ubk.service;

import kg.mlsp.ubk.dto.application.UbkAttachmentCreateDto;
import kg.mlsp.ubk.dto.application.UbkAttachmentDto;

import java.util.List;


public interface UbkAttachmentService {
    UbkAttachmentDto create(Integer applicationId, UbkAttachmentCreateDto createDto);
    UbkAttachmentDto update(Integer id, UbkAttachmentCreateDto createDto);
    UbkAttachmentDto getById(Integer id);
    List<UbkAttachmentDto> list(Integer applicationId);
    String delete(Integer id);
}
