package org.academiadecodigo.whiledlings.hackathon.persistence.model.solicitation;

import org.academiadecodigo.whiledlings.hackathon.persistence.model.AbstractModel;
import org.academiadecodigo.whiledlings.hackathon.persistence.model.Person;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="solicitation_type")
public abstract class Solicitation extends AbstractModel {


    private String description;
    private String type;

    @ManyToOne
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

    public String getSolicitationType(){

        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
