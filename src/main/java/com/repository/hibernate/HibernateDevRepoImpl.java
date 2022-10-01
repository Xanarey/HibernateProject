package com.repository.hibernate;

import com.model.Developer;
import com.repository.DeveloperRepo;
import com.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class HibernateDevRepoImpl implements DeveloperRepo {

    @Override
    public List<Developer> getAll() {
        return HibernateUtil.getSession()
                .createQuery("FROM Developer").list();
    }

    @Override
    public Developer getById(Long id) {
        return HibernateUtil.getSession().get(Developer.class, id);
    }

    @Override
    public Developer insert(Developer developer) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.merge(developer);
        session.getTransaction().commit();
        session.close();
        return developer;
    }

    @Override
    public void deleteById(Long id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.remove(session.get(Developer.class, id));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Developer update(Developer developer) {
        insert(developer);
        return developer;
    }

}


