package org.academiadecodigo.whiledlings.hackathon.service;

import org.academiadecodigo.whiledlings.hackathon.persistence.model.Person;
import org.academiadecodigo.whiledlings.hackathon.persistence.model.solicitation.Solicitation;

import java.util.List;

public interface PersonServiceInt {

    Person get(Integer id);

    Person save (Person person);

    void delete(Integer id);

    List<Person> list();

    Solicitation addSolicitation (Integer id, Solicitation solicitation);

    void closeSolicitation (Integer id, Integer solicitationId);

}
