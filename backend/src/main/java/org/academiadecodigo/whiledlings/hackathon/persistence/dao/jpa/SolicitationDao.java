package org.academiadecodigo.whiledlings.hackathon.persistence.dao.jpa;

import org.academiadecodigo.whiledlings.hackathon.persistence.model.solicitation.Solicitation;

import java.util.List;

public class SolicitationDao extends GenericDao<Solicitation>{

    public SolicitationDao(){
        super(Solicitation.class);
    }


}
