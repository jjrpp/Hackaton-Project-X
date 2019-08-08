package org.academiadecodigo.whiledlings.hackathon.converter;

import org.academiadecodigo.whiledlings.hackathon.dto.PersonDto;
import org.academiadecodigo.whiledlings.hackathon.persistence.model.Person;
import org.academiadecodigo.whiledlings.hackathon.service.PersonServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class PersonDtoToPersonConverter implements Converter<PersonDto, Person> {

    private PersonServiceInt personService;

    @Autowired
    public void setPersonService(PersonServiceInt personService) {
        this.personService = personService;
    }


    @Override
    public Person convert(PersonDto personDto) {

        System.out.println("aaaaaaaa-------------------------------------------");
        System.out.println("Chegou aqui");
        System.out.println("aaaaaaaa-------------------------------------------");

        Person person = (personDto.getId() != null ? personService.get(personDto.getId()) : new Person());


        System.out.println("aaaaaaaa-------------------------------------------");
        System.out.println("id da person "+person.getId());
        System.out.println("aaaaaaaa-------------------------------------------");


        person.setFirstName(personDto.getFirstName());
        person.setLastName(personDto.getLastName());
        person.setEmail(personDto.getEmail());
        person.setPhone(personDto.getPhone());

        return person;
    }
}
