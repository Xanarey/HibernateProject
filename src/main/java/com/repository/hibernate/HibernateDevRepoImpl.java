package com.repository.hibernate;

import com.model.Developer;
import com.repository.DeveloperRepo;
import com.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HibernateDevRepoImpl implements DeveloperRepo {

    @Override
    public Developer insert(Developer developer) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Developer dev = new Developer("A", "B", "ACTIVE", 1);
        // TODO собрать сверху
        session.persist(dev);
        session.getTransaction().commit();
        session.close();
        return dev;
    }

    @Override
    public List<Developer> getAll() {
        Session session = HibernateUtil.getSession();
        List<Developer> devList = session.createQuery("FROM Developer", Developer.class).list();
        session.close();
        return devList;
    }
    @Override
    public Developer getById(Long id) {
        Session session = HibernateUtil.getSession();
        Developer developer = session.get(Developer.class, id);
        session.close();
        return developer;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public Developer update(Developer developer) {
        return null;
    }

}
