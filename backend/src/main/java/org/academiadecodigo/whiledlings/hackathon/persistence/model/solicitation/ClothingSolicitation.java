package org.academiadecodigo.whiledlings.hackathon.persistence.model.solicitation;

import javax.persistence.Entity;

@Entity
public class ClothingSolicitation extends Solicitation {

    @Override
    public String getSolicitationType() {
        return "CLOTHINGSOLICITATION";
    }
}
