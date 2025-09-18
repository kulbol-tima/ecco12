package kg.mlsp.ubk.service;

import kg.mlsp.ubk.dto.familymember.UbkApplicationFamilyMemberCreateDto;
import kg.mlsp.ubk.dto.familymember.UbkApplicationFamilyMemberDto;

import java.util.List;

public interface UbkApplicationFamilyMemberService {
    UbkApplicationFamilyMemberDto create(Integer applicationId, UbkApplicationFamilyMemberCreateDto createDto);
    UbkApplicationFamilyMemberDto update(Integer id, UbkApplicationFamilyMemberCreateDto createDto);
    UbkApplicationFamilyMemberDto getById(Integer id);
    List<UbkApplicationFamilyMemberDto> list(Integer applicationId);
    String delete(Integer id);
}
