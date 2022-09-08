package com.repository.hibernate;

import com.model.Specialty;
import com.repository.SpecialtyRepo;
import com.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class HibernateSpecRepoImpl implements SpecialtyRepo  {

    @Override
    public List<Specialty> getAll() {
        Session session = HibernateUtil.getSession();
        List<Specialty> specList = session.createQuery("FROM Specialty", Specialty.class).list();
        session.close();
        return specList;
    }

    @Override
    public Specialty getById(Long id) {
        Session session = HibernateUtil.getSession();
        Specialty specialty = session.get(Specialty.class, id);
        session.close();
        return specialty;
    }

    @Override
    public Specialty insert(Specialty specialty) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.persist(specialty);
        session.getTransaction().commit();
        session.close();
        return specialty;
    }

    @Override
    public void deleteById(Long id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Specialty specialty = session.get(Specialty.class, id);
        session.delete(specialty);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Specialty update(Specialty specialty) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(specialty);
        session.getTransaction().commit();
        session.close();
        return specialty;
    }

}
