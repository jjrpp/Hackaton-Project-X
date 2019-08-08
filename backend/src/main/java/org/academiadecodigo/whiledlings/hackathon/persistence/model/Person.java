package org.academiadecodigo.whiledlings.hackathon.persistence.model;

import org.academiadecodigo.whiledlings.hackathon.persistence.model.solicitation.Solicitation;

import java.util.ArrayList;
import java.util.List;

public class Person extends AbstractModel {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;
    private List<Solicitation> solicitations = new ArrayList<>();


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public List<Solicitation> getSolicitations() {
        return solicitations;
    }

    public void setSolicitations(List<Solicitation> solicitations) {
        this.solicitations = solicitations;
    }
}
