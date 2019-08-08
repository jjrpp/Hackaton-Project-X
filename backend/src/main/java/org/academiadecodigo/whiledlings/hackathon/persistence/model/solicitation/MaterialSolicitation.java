package org.academiadecodigo.whiledlings.hackathon.persistence.model.solicitation;

import javax.persistence.Entity;

@Entity
public class MaterialSolicitation extends Solicitation {
    @Override
    public SolicitationType getSolicitationType() {
        return SolicitationType.MATERIALSOLICITATION;
    }
}
