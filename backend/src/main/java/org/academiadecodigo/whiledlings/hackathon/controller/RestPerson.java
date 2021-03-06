package org.academiadecodigo.whiledlings.hackathon.controller;


import org.academiadecodigo.whiledlings.hackathon.converter.PersonDtoToPersonConverter;
import org.academiadecodigo.whiledlings.hackathon.converter.PersonToPersonDtoConverter;
import org.academiadecodigo.whiledlings.hackathon.dto.PersonDto;
import org.academiadecodigo.whiledlings.hackathon.persistence.model.Person;
import org.academiadecodigo.whiledlings.hackathon.service.PersonServiceInt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/person")
public class RestPerson {

    private PersonServiceInt personService;
    private PersonToPersonDtoConverter personToPersonDtoConverter;
    private PersonDtoToPersonConverter personDtoToPersonConverter;


    public PersonServiceInt getPersonService() {
        return personService;
    }

    @Autowired
    public void setPersonService(PersonServiceInt personService) {
        this.personService = personService;
    }

    public PersonToPersonDtoConverter getPersonToPersonDtoConverter() {
        return personToPersonDtoConverter;
    }

    @Autowired
    public void setPersonToPersonDtoConverter(PersonToPersonDtoConverter personToPersonDtoConverter) {
        this.personToPersonDtoConverter = personToPersonDtoConverter;
    }

    public PersonDtoToPersonConverter getPersonDtoToPersonConverter() {
        return personDtoToPersonConverter;
    }

    @Autowired
    public void setPersonDtoToPersonConverter(PersonDtoToPersonConverter personDtoToPersonConverter) {
        this.personDtoToPersonConverter = personDtoToPersonConverter;
    }

    @RequestMapping(method = RequestMethod.GET, path={"/", ""})
    public ResponseEntity<List<PersonDto>> listPersons() {

        List<PersonDto> personDtoList = new ArrayList<>();

        for (Person person:personService.list()) {
            personDtoList.add(personToPersonDtoConverter.convert(person));
        }
        return new ResponseEntity<>(personDtoList, HttpStatus.OK);
    }


    @RequestMapping(method = RequestMethod.GET, path="/{id}")
    public ResponseEntity<PersonDto> showPerson(@PathVariable Integer id){

        Person person = personService.get(id);

        if (person == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(personToPersonDtoConverter.convert(person), HttpStatus.OK);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(method = RequestMethod.POST, path = {"/register", ""})
    public ResponseEntity<?> addPerson(@Valid @RequestBody PersonDto personDto, BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder) {

        System.out.println("###### CHEGOU AAQQUI #######################");
        System.out.println("###### CHEGOU AAQQUI #######################");
        System.out.println("###### CHEGOU AAQQUI #######################");
        System.out.println("###### CHEGOU AAQQUI #######################");
        if (bindingResult.hasErrors() || personDto.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Person converted = personDtoToPersonConverter.convert(personDto);

        Person savedPerson = personService.save(converted);

        // get help from the framework building the path for the newly created resource
        UriComponents uriComponents = uriComponentsBuilder.path("/api/person/" + savedPerson.getId()).build();

        // set headers with the created path
        HttpHeaders headers = new HttpHeaders();
        headers.setLocation(uriComponents.toUri());

        return new ResponseEntity<>(headers, HttpStatus.CREATED);

    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public ResponseEntity<PersonDto> editPerson(@Valid @RequestBody PersonDto personDto, BindingResult bindingResult, @PathVariable Integer id) {

        if (bindingResult.hasErrors()) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (personDto.getId() != null && !personDto.getId().equals(id)) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        if (personService.get(id) == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        personDto.setId(id);

        personService.save(personDtoToPersonConverter.convert(personDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
