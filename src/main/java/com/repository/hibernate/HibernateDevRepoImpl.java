package com.repository.hibernate;

import com.model.Developer;
import com.repository.DeveloperRepo;
import com.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class HibernateDevRepoImpl implements DeveloperRepo {

    @Override
    public Developer insert(Developer developer) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Developer dev = new Developer("A", "B", "DELETED", 1);
        // TODO собрать сверху
        session.persist(dev);
        session.getTransaction().commit();
        session.close();
        return dev;
    }

    @Override
    public List<Developer> getAll() {
        Session session = HibernateUtil.getSession();
        List<Developer> devList = session.createQuery("FROM Developer", Developer.class).list(); // TODO переделать String на STATUS
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
    public void deleteById(Long id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Developer developer = session.get(Developer.class, 35);
        // TODO взять ID сверху
        session.delete(developer);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Developer update(Developer developer) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(developer);
        session.getTransaction().commit();
        session.close();
        return developer;
    }

}
