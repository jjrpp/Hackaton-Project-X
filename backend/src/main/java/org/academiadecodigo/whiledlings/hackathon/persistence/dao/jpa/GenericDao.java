package org.academiadecodigo.whiledlings.hackathon.persistence.dao.jpa;

import org.academiadecodigo.whiledlings.hackathon.persistence.model.Model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public abstract class GenericDao<T extends Model> implements Dao<T>{

    protected Class<T> modelType;

    public void setEm(EntityManager em) {
        this.em = em;
    }

    @PersistenceContext
    protected EntityManager em;

    @Override
    public List<T> findAll() {

        CriteriaQuery<T> criteriaQuery = em.getCriteriaBuilder().createQuery(modelType);
        Root<T> root = criteriaQuery.from(modelType);
        return em.createQuery(criteriaQuery).getResultList();

    }


    public GenericDao(Class<T> modelType){
        this.modelType= modelType;
    }

    @Override
    public T findById(Integer id) {
        return em.find(modelType, id);
    }

    @Override
    public T saveOrUpdate(T modelObject) {
        return em.merge(modelObject);
    }


    @Override
    public void delete(Integer id) {
        em.remove(em.find(modelType, id));
    }
}



