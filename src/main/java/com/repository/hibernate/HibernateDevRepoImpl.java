package com.repository.hibernate;

import com.model.Developer;
import com.repository.DeveloperRepo;
import com.utils.SessionUtils;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class HibernateDevRepoImpl implements DeveloperRepo {

    @Override
    public Object insert(Object o) {
        return null;
    }

    @Override
    public List<Developer> getAll() {
        Session session = SessionUtils.getSession();
        List<Developer> devList = session.createQuery("FROM Developer", Developer.class).list();
        return devList;
    }

    @Override
    public Object getById(Object o) {
        return null;
    }

    @Override
    public void deleteById(Object o) {

    }

    @Override
    public Object update(Object o) {
        return null;
    }
}
