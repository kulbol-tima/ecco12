package kg.mlsp.common.service;

import kg.mlsp.common.dto.person.PersonDto;
import kg.mlsp.common.dto.person.PersonShortDto;
import kg.mlsp.common.mapper.PersonMapper;
import kg.mlsp.common.repository.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonMapperServiceImp implements PersonMapperService {

    private final PersonRepository personRepository;
    private final PersonMapper personMapper;

    @Override
    public PersonDto getPerson(Integer id) {

        var person = personRepository.findById(id).orElse(null);

        if (person != null)
        {
            return personMapper.toDto(person);
        }

        return null;
    }

    @Override
    public PersonShortDto getPersonShort(Integer id) {

        var person = personRepository.findById(id).orElse(null);

        if (person != null)
        {
            return personMapper.toDtoShort(person);
        }

        return null;
    }
}
