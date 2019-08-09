package org.academiadecodigo.whiledlings.hackathon.dto;

import org.academiadecodigo.whiledlings.hackathon.persistence.model.Person;
import org.academiadecodigo.whiledlings.hackathon.persistence.model.solicitation.SolicitationType;
import org.springframework.beans.factory.annotation.Autowired;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class SolicitationDto {

    private Integer id;



    @NotNull(message = "Description is mandatory")
    @NotBlank(message = "Description is mandatory")
    @Size(min = 3)
    private String description;

    @NotNull(message = "Type is mandatory")
    @NotBlank(message = "Description is mandatory")
    private String type;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }



    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSolicitationType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "CustomerForm{" +
                "id=" + id +
                //", person='" + person.getFirstName() + '\'' +
                ", description='" + description + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

}
