package org.academiadecodigo.whiledlings.hackathon.service;

import org.academiadecodigo.whiledlings.hackathon.persistence.dao.jpa.PersonDao;
import org.academiadecodigo.whiledlings.hackathon.persistence.dao.jpa.SolicitationDao;
import org.academiadecodigo.whiledlings.hackathon.persistence.model.solicitation.Solicitation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SolicitationService implements SolicitationServicceInt {

    private SolicitationDao solicitationDao;
    private PersonDao personDao;


    @Autowired
    public void setSolicitationDao(SolicitationDao solicitationDao) {

        this.solicitationDao = solicitationDao;
    }

    @Autowired
    public void setPersonDao(PersonDao personDao) {

        this.personDao = personDao;
    }

    @Override
    public Solicitation get(Integer id) {

        return solicitationDao.findById(id);
    }

    @Override
    public Solicitation save(Solicitation solicitation) {
        return solicitationDao.saveOrUpdate(solicitation);
    }

    @Override
    public List<Solicitation> list() {
        return solicitationDao.findAll();
    }


}
