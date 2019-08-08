package org.academiadecodigo.whiledlings.hackathon.persistence.dao.jpa;

import org.academiadecodigo.whiledlings.hackathon.persistence.model.solicitation.Solicitation;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class SolicitationDao extends GenericDao<Solicitation>{

    public SolicitationDao(){
        super(Solicitation.class);
    }


}
