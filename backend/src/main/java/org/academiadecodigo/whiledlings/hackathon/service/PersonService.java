package org.academiadecodigo.whiledlings.hackathon.service;

import org.academiadecodigo.whiledlings.hackathon.persistence.dao.jpa.PersonDao;
import org.academiadecodigo.whiledlings.hackathon.persistence.dao.jpa.SolicitationDao;
import org.academiadecodigo.whiledlings.hackathon.persistence.model.Person;
import org.academiadecodigo.whiledlings.hackathon.persistence.model.solicitation.Solicitation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class PersonService implements PersonServiceInt {


    private PersonDao personDao;
    private SolicitationDao solicitationDao;


    @Autowired
    public void setPersonDao(PersonDao personDao) {

        this.personDao = personDao;
    }


    @Autowired
    public void setSolicitationDao(SolicitationDao solicitationDao) {

        this.solicitationDao = solicitationDao;
    }

    @Override
    public Person get(Integer id) {

        return personDao.findById(id);
    }


    @Transactional
    @Override
    public Person save(Person person) {

        return personDao.saveOrUpdate(person);
    }

    @Transactional
    @Override
    public void delete(Integer id) {

        Person person = personDao.findById(id);

        if (person == null){
            // Exception
        }
        personDao.delete(id);

    }

    @Override
    public List<Person> list() {

        return personDao.findAll();
    }

    @Transactional
    @Override
    public Solicitation addSolicitation(Integer id, Solicitation solicitation) {

        Person person = personDao.findById(id);

        if (person == null) {
            // Exception
        }
        person.addSolicitation(solicitation);
        personDao.saveOrUpdate(person);

        return null;
    }

    @Transactional
    @Override
    public void closeSolicitation(Integer id, Integer solicitationId) {

        Person person = personDao.findById(id);
        Solicitation solicitation = solicitationDao.findById(solicitationId);

        if (person == null){
            // Exception
        }

        if (solicitation == null || !solicitation.getPerson().getId().equals(id)){
            // Exception
        }

        person.removeSolicitation(solicitation);
        personDao.saveOrUpdate(person);
    }
}
