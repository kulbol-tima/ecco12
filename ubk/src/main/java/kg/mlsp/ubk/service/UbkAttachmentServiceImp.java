package kg.mlsp.ubk.service;

import kg.mlsp.common.exception.ApiException;
import kg.mlsp.common.exception.ErrorCode;
import kg.mlsp.common.exception.ErrorMessage;
import kg.mlsp.common.exception.SuccessMessage;
import kg.mlsp.common.model.reference.RefDocumentType;
import kg.mlsp.common.repository.reference.RefDocumentTypeRepository;
import kg.mlsp.ubk.dto.application.UbkAttachmentCreateDto;
import kg.mlsp.ubk.dto.application.UbkAttachmentDto;
import kg.mlsp.ubk.mapper.UbkAttachmentMapper;
import kg.mlsp.ubk.model.UbkApplication;
import kg.mlsp.ubk.model.UbkAttachment;
import kg.mlsp.ubk.repository.UbkApplicationRepository;
import kg.mlsp.ubk.repository.UbkAttachmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UbkAttachmentServiceImp implements UbkAttachmentService {

    private final RefDocumentTypeRepository refDocumentTypeRepository;
    private final UbkApplicationRepository ubkApplicationRepository;
    private final UbkAttachmentRepository ubkAttachmentRepository;
    private final UbkAttachmentMapper ubkAttachmentMapper;


    @Override
    public UbkAttachmentDto create(Integer applicationId, UbkAttachmentCreateDto createDto) {
        checkDataIsValid(createDto);
        UbkApplication application = getApplication(applicationId);

        UbkAttachment ubkAttachment = new UbkAttachment();
        ubkAttachment.setApplication(application);
        ubkAttachment.setDocumentTypeId(createDto.getDocumentTypeId());
        ubkAttachment.setFileId(createDto.getFileId());
        ubkAttachment.setFilePath(createDto.getFilePath());

        ubkAttachmentRepository.save(ubkAttachment);

        return ubkAttachmentMapper.toDto(ubkAttachment);
    }

    @Override
    public UbkAttachmentDto update(Integer id, UbkAttachmentCreateDto createDto) {
        checkDataIsValid(createDto);

        UbkAttachment ubkAttachment = ubkAttachmentRepository.findById(id).orElse(null);
        if(ubkAttachment == null){
            throw new ApiException(ErrorCode.NOT_FOUND, String.format(ErrorMessage.ATTACHMENT_NOT_FOUND, id));
        }
        ubkAttachment.setDocumentTypeId(createDto.getDocumentTypeId());
        ubkAttachment.setFileId(createDto.getFileId());
        ubkAttachment.setFilePath(createDto.getFilePath());

        ubkAttachmentRepository.save(ubkAttachment);

        return ubkAttachmentMapper.toDto(ubkAttachment);
    }

    @Override
    public UbkAttachmentDto getById(Integer id) {
        UbkAttachment ubkAttachment = ubkAttachmentRepository.findById(id).orElse(null);
        if(ubkAttachment == null){
            throw new ApiException(ErrorCode.NOT_FOUND, String.format(ErrorMessage.ATTACHMENT_NOT_FOUND, id));
        }
        return ubkAttachmentMapper.toDto(ubkAttachment);
    }

    @Override
    public List<UbkAttachmentDto> list(Integer applicationId) {
        List<UbkAttachment> list = ubkAttachmentRepository.findByApplicationId(applicationId);
        return ubkAttachmentMapper.toDtoList(list);
    }

    @Override
    public String delete(Integer id) {

        UbkAttachment ubkAttachment = ubkAttachmentRepository.findById(id).orElse(null);
        if(ubkAttachment == null){
            throw new ApiException(ErrorCode.NOT_FOUND, String.format(ErrorMessage.ATTACHMENT_NOT_FOUND, id));
        }
        ubkAttachment.markAsDeleted();
        ubkAttachmentRepository.save(ubkAttachment);
        return SuccessMessage.RECORD_DELETED;
    }


    private void checkDataIsValid(UbkAttachmentCreateDto createDto){
        if(createDto.getFileId() == null){
            throw new ApiException(ErrorCode.BAD_REQUEST, ErrorMessage.ATTACHMENT_FILE_EMPTY);
        }
        if(createDto.getDocumentTypeId() == null){
            throw new ApiException(ErrorCode.BAD_REQUEST, ErrorMessage.ATTACHMENT_DOCUMENT_TYPE_EMPTY);
        }
        RefDocumentType documentType = refDocumentTypeRepository.findById(createDto.getDocumentTypeId()).orElse(null);
        if(documentType == null){
            throw new ApiException(ErrorCode.BAD_REQUEST, ErrorMessage.ATTACHMENT_DOCUMENT_TYPE_NOT_FOUND);
        }
    }

    private UbkApplication getApplication(Integer applicationId){

        UbkApplication application = ubkApplicationRepository.findById(applicationId).orElse(null);

        if(application == null){
            throw new ApiException(ErrorCode.NOT_FOUND, String.format(ErrorMessage.APPLICATION_NOT_FOUND, applicationId));
        }

        return  application;
    }




}
