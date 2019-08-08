package org.academiadecodigo.whiledlings.hackathon.persistence.model.solicitation;

import org.academiadecodigo.whiledlings.hackathon.persistence.model.AbstractModel;
import org.academiadecodigo.whiledlings.hackathon.persistence.model.Person;

public abstract class Solicitation extends AbstractModel {


    private String description;
    private Person person;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
