package com.repository.hibernate;

import com.model.Developer;
import com.repository.DeveloperRepo;
import com.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class HibernateDevRepoImpl implements DeveloperRepo {

    @Override
    public List<Developer> getAll() {
        List<Developer> developerList = new ArrayList<>();
        Transaction transaction = null;
        try(Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            developerList = session.createQuery("FROM Developer", Developer.class).list();
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return developerList;
    }

    @Override
    public Developer getById(Long id) {
        Developer developer = new Developer();
        try (Session session = HibernateUtil.getSession()){
            developer =  (Developer) session.createQuery("SELECT d FROM Developer d JOIN FETCH d.skills JOIN FETCH d.specialty WHERE d.id = 3").getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return developer;
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


