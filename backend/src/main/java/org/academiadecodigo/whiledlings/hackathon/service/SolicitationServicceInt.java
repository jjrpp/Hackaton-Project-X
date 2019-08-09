package org.academiadecodigo.whiledlings.hackathon.service;

import org.academiadecodigo.whiledlings.hackathon.persistence.model.solicitation.Solicitation;

import java.util.List;

public interface SolicitationServicceInt {

    Solicitation get (Integer id);

    Solicitation save (Solicitation solicitation);

    List<Solicitation> list();


}
