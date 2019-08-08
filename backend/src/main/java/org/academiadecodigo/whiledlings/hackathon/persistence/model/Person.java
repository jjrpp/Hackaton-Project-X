package org.academiadecodigo.whiledlings.hackathon.persistence.model;

import org.academiadecodigo.whiledlings.hackathon.persistence.model.solicitation.Solicitation;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "person")
public class Person extends AbstractModel {

    private String firstName;
    private String lastName;
    private String email;
    private String phone;

    @OneToMany(
            // propagate changes on customer entity to account entities
            cascade = {CascadeType.ALL},

            // make sure to remove accounts if unlinked from customer
            orphanRemoval = true,

            // user customer foreign key on account table to establish
            // the many-to-one relationship instead of a join table
            mappedBy = "person",

            // fetch accounts from database together with user
            fetch = FetchType.EAGER
    )
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

    public void addSolicitation(Solicitation solicitation){
        solicitations.add(solicitation);
        solicitation.setPerson(this);

    }

    public void removeSolicitation(Solicitation solicitation){
        solicitations.remove(solicitation);
        solicitation.setPerson(null);

    }

    @Override
    public String toString(){
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phone='" + phone + '\'' +
                ", solicitations=" + solicitations +
                "} " + super.toString();


    }
}
