package kg.mlsp.ubk.service;

import kg.mlsp.common.exception.ApiException;
import kg.mlsp.common.exception.ErrorCode;
import kg.mlsp.common.exception.ErrorMessage;
import kg.mlsp.common.exception.SuccessMessage;
import kg.mlsp.ubk.dto.familymember.UbkApplicationFamilyMemberCreateDto;
import kg.mlsp.ubk.dto.familymember.UbkApplicationFamilyMemberDto;
import kg.mlsp.ubk.mapper.UbkApplicationFamilyMemberMapper;
import kg.mlsp.ubk.model.UbkApplicationFamilyMember;
import kg.mlsp.ubk.repository.UbkApplicationFamilyMemberRepository;
import kg.mlsp.ubk.repository.UbkApplicationRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UbkApplicationFamilyMemberServiceImp implements UbkApplicationFamilyMemberService {

    private final UbkApplicationFamilyMemberMapper applicationFamilyMemberMapper;
    private final UbkApplicationRepository ubkApplicationRepository;
    private final UbkApplicationFamilyMemberRepository ubkApplicationFamilyMemberRepository;

    @Override
    public UbkApplicationFamilyMemberDto create(Integer applicationId, UbkApplicationFamilyMemberCreateDto createDto) {

        var application = ubkApplicationRepository.findById(applicationId)
                .orElseThrow(() -> new ApiException(ErrorCode.NOT_FOUND, String.format(ErrorMessage.APPLICATION_NOT_FOUND, applicationId)));


        var familyMember = new UbkApplicationFamilyMember();
        familyMember.setApplication(application);

        familyMember.setFamilyMemberId(createDto.getPersonId());
        familyMember.setEmploymentTypeId(createDto.getEmploymentTypeId());
        familyMember.setPersonCategoryId(createDto.getCategoryTypeId());
        familyMember.setRelationshipTypeId(createDto.getRelationshipTypeId());

        familyMember = ubkApplicationFamilyMemberRepository.save(familyMember);

        log.info("Created family member for application with ID: {}", applicationId);

        return applicationFamilyMemberMapper.toDto(familyMember);
    }

    @Override
    public UbkApplicationFamilyMemberDto update(Integer id, UbkApplicationFamilyMemberCreateDto createDto) {

        var familyMember = ubkApplicationFamilyMemberRepository.findById(id)
                .orElseThrow(() -> new ApiException(ErrorCode.NOT_FOUND, String.format(ErrorMessage.FAMILY_MEMBER_NOT_FOUND, id)));

        familyMember.setFamilyMemberId(createDto.getPersonId());
        familyMember.setEmploymentTypeId(createDto.getEmploymentTypeId());
        familyMember.setPersonCategoryId(createDto.getCategoryTypeId());
        familyMember.setRelationshipTypeId(createDto.getRelationshipTypeId());

        familyMember = ubkApplicationFamilyMemberRepository.save(familyMember);

        return applicationFamilyMemberMapper.toDto(familyMember);
    }

    @Override
    public UbkApplicationFamilyMemberDto getById(Integer id) {
        var familyMember = ubkApplicationFamilyMemberRepository.findById(id)
                .orElseThrow(() -> new ApiException(ErrorCode.NOT_FOUND, String.format(ErrorMessage.FAMILY_MEMBER_NOT_FOUND, id)));

        return applicationFamilyMemberMapper.toDto(familyMember);
    }

    @Override
    public List<UbkApplicationFamilyMemberDto> list(Integer applicationId) {
        var application = ubkApplicationRepository.findById(applicationId)
                .orElseThrow(() -> new ApiException(ErrorCode.NOT_FOUND, String.format(ErrorMessage.APPLICATION_NOT_FOUND, applicationId)));

        var familyMemberList = ubkApplicationFamilyMemberRepository.findByApplicationId(application.getId());

        return applicationFamilyMemberMapper.toDtoList(familyMemberList);
    }

    @Override
    public String delete(Integer id) {
        var familyMember = ubkApplicationFamilyMemberRepository.findById(id).orElseThrow(
                () -> new ApiException(ErrorCode.NOT_FOUND,  String.format(ErrorMessage.FAMILY_MEMBER_NOT_FOUND, id)));

        familyMember.markAsDeleted();
        ubkApplicationFamilyMemberRepository.save(familyMember);

        return SuccessMessage.RECORD_DELETED;
    }
}
