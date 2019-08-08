package org.academiadecodigo.whiledlings.hackathon.dto;

import org.academiadecodigo.whiledlings.hackathon.persistence.model.Person;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SolicitationDto {

    private Integer id;

    private Person person;

    @NotNull(message = "Description is mandatory")
    @NotBlank(message = "Description is mandatory")
    @Size(min = 3)
    private String description;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "CustomerForm{" +
                "id=" + id +
                ", person='" + person.getFirstName() + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
