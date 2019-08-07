package org.academiadecodigo.whiledlings.hackathon.service;

import org.academiadecodigo.whiledlings.hackathon.persistence.dao.jpa.FakeDao;
import org.academiadecodigo.whiledlings.hackathon.persistence.model.FakeModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class FakeService {

    private FakeDao fakeDao;

    @Autowired
    public void setFakeDao(FakeDao fakeDao) {
        this.fakeDao = fakeDao;
    }

    @Transactional
    public FakeModel save(FakeModel fakeModel) {
        return fakeDao.saveOrUpdate(fakeModel);
    }

    public FakeModel getFake(Integer id){
        return fakeDao.findById(id);
    }
}
