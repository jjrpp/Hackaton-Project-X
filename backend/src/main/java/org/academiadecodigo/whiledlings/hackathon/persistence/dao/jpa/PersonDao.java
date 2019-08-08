package org.academiadecodigo.whiledlings.hackathon.persistence.dao.jpa;

import org.academiadecodigo.whiledlings.hackathon.persistence.model.Person;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PersonDao extends GenericDao<Person> {

    public PersonDao(){
        super(Person.class);
    }
}
