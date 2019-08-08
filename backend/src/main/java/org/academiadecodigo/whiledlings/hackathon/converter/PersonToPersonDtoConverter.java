package org.academiadecodigo.whiledlings.hackathon.converter;

import org.academiadecodigo.whiledlings.hackathon.dto.PersonDto;
import org.academiadecodigo.whiledlings.hackathon.persistence.model.Person;
import org.springframework.stereotype.Component;

@Component
public class PersonToPersonDtoConverter extends AbstractConverter<Person, PersonDto> {


    @Override
    public PersonDto convert(Person person) {
        PersonDto personDto = new PersonDto();

        personDto.setId(person.getId());
        personDto.setFirstName(person.getFirstName());
        personDto.setLastName(person.getLastName());
        personDto.setEmail(person.getEmail());
        personDto.setPhone(person.getPhone());

        return personDto;
    }
}
