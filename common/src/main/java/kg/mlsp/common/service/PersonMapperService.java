package kg.mlsp.common.service;

import kg.mlsp.common.dto.person.PersonDto;
import kg.mlsp.common.dto.person.PersonShortDto;

public interface PersonMapperService {
    PersonDto getPerson(Integer id);
    PersonShortDto getPersonShort(Integer id);

}
