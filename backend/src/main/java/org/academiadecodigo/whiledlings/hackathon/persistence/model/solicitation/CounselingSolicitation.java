package org.academiadecodigo.whiledlings.hackathon.persistence.model.solicitation;

import javax.persistence.Entity;

@Entity
public class CounselingSolicitation extends Solicitation {

    @Override
    public String getSolicitationType() {
        return "COUNSELINGSOLICITATION";
    }
}
