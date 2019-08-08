package org.academiadecodigo.whiledlings.hackathon.controller;

import org.academiadecodigo.whiledlings.hackathon.converter.SolicitationDtoToSolicitation;
import org.academiadecodigo.whiledlings.hackathon.converter.SolicitationToSolicitationDtoConverter;
import org.academiadecodigo.whiledlings.hackathon.dto.PersonDto;
import org.academiadecodigo.whiledlings.hackathon.dto.SolicitationDto;
import org.academiadecodigo.whiledlings.hackathon.persistence.model.Person;
import org.academiadecodigo.whiledlings.hackathon.persistence.model.solicitation.Solicitation;
import org.academiadecodigo.whiledlings.hackathon.service.PersonServiceInt;
import org.academiadecodigo.whiledlings.hackathon.service.SolicitationServicceInt;
import org.academiadecodigo.whiledlings.hackathon.service.SolicitationService;
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
public class RestSolicitation {

    private SolicitationServicceInt solicitationServicceInt;
    private SolicitationToSolicitationDtoConverter solicitationToSolicitationDtoConverter;
    private SolicitationDtoToSolicitation solicitationDtoToSolicitation;
    private PersonServiceInt personServiceInt;

    public PersonServiceInt getPersonServiceInt() {
        return personServiceInt;
    }

    public void setPersonServiceInt(PersonServiceInt personServiceInt) {
        this.personServiceInt = personServiceInt;
    }

    @Autowired
    public SolicitationServicceInt getSolicitationServicceInt() {
        return solicitationServicceInt;
    }

    @Autowired
    public void setSolicitationServicceInt(SolicitationServicceInt solicitationServicceInt) {
        this.solicitationServicceInt = solicitationServicceInt;
    }

    @Autowired
    public SolicitationToSolicitationDtoConverter getSolicitationToSolicitationDtoConverter() {
        return solicitationToSolicitationDtoConverter;
    }

    @Autowired
    public void setSolicitationToSolicitationDtoConverter(SolicitationToSolicitationDtoConverter solicitationToSolicitationDtoConverter) {
        this.solicitationToSolicitationDtoConverter = solicitationToSolicitationDtoConverter;
    }

    @Autowired
    public SolicitationDtoToSolicitation getSolicitationDtoToSolicitation() {
        return solicitationDtoToSolicitation;
    }

    @Autowired
    public void setSolicitationDtoToSolicitation(SolicitationDtoToSolicitation solicitationDtoToSolicitation) {
        this.solicitationDtoToSolicitation = solicitationDtoToSolicitation;
    }

    @RequestMapping(method = RequestMethod.GET, path="{cid}/solicitation")
    public ResponseEntity<List<SolicitationDto>> listPersonSolicitations(@PathVariable Integer cid) {

        Person person = personServiceInt.get(cid);

        List<SolicitationDto> solicitationDtoList = new ArrayList<>();

        for (Solicitation solicitation : person.getSolicitations()) {
            solicitationDtoList.add(solicitationToSolicitationDtoConverter.convert(solicitation));
        }
        return new ResponseEntity<>(solicitationDtoList, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, path="{cid}/solicitation/{sid}")
    public ResponseEntity<SolicitationDto> showPersonSpecificSolicitation(@PathVariable Integer cid, @PathVariable Integer sid){

        Solicitation solicitation = solicitationServicceInt.get(sid);

        if (solicitation == null || solicitation.getPerson() == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        if (!solicitation.getPerson().getId().equals(cid)) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(solicitationToSolicitationDtoConverter.convert(solicitation), HttpStatus.OK);

    }

    @RequestMapping(method = RequestMethod.POST, path="{cid}/solicitation")
    public ResponseEntity<?> addPerson(@PathVariable Integer cid, @Valid @RequestBody SolicitationDto solicitationDto,
                                       BindingResult bindingResult, UriComponentsBuilder uriComponentsBuilder){


        if (bindingResult.hasErrors() ||solicitationDto.getId() != null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        //try {

            Solicitation solicitation = personServiceInt.addSolicitation(cid, solicitationDtoToSolicitation.convert(solicitationDto));

            UriComponents uriComponents = uriComponentsBuilder.path("/api/person/" + cid + "/solicitation/" + solicitation.getId()).build();
            HttpHeaders headers = new HttpHeaders();
            headers.setLocation(uriComponents.toUri());

            return new ResponseEntity<>(headers, HttpStatus.CREATED);

        /*} catch (PersonNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (TransactionInvalidException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }*/
    }


    @RequestMapping(method = RequestMethod.GET, path = "/{cid}/solicitation/{sid}/close")
    public ResponseEntity<?> closeSolicitation(@PathVariable Integer cid, @PathVariable Integer sid) {

        //try {

            personServiceInt.closeSolicitation(cid, sid);

            return new ResponseEntity<>(HttpStatus.OK);

        /*} catch (PersonNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (SolicitationNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);

        } catch (TransactionInvalidException e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);

        }*/
    }

}
