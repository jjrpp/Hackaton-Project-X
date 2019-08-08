package org.academiadecodigo.whiledlings.hackathon.persistence.dao.jpa;

import org.academiadecodigo.whiledlings.hackathon.persistence.model.Model;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public abstract class GenericDao<T extends Model> implements Dao<T>{

    protected Class<T> modelType;

    @PersistenceContext
    protected EntityManager em;
}
