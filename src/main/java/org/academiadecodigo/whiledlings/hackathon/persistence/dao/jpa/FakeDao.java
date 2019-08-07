package org.academiadecodigo.whiledlings.hackathon.persistence.dao.jpa;

import org.academiadecodigo.whiledlings.hackathon.persistence.model.FakeModel;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class FakeDao {

    @PersistenceContext
    protected EntityManager em;


    public void setEm(EntityManager em) {
        this.em = em;
    }

    public FakeModel saveOrUpdate(FakeModel fakeModel){
        return em.merge(fakeModel);
    }

    public FakeModel findById(Integer id) {
        return em.find(FakeModel.class,id);
    }
}
