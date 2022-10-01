package com.repository.hibernate;

import com.model.Specialty;
import com.repository.SpecialtyRepo;
import com.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class HibernateSpecRepoImpl implements SpecialtyRepo  {

    @Override
    public List<Specialty> getAll() {
        return HibernateUtil.getSession().createQuery("FROM Specialty", Specialty.class).list();
    }

    @Override
    public Specialty getById(Long id) {
        return HibernateUtil.getSession().get(Specialty.class, id);
    }

    @Override
    public Specialty insert(Specialty specialty) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.merge(specialty);
        session.getTransaction().commit();
        session.close();
        return specialty;
    }

    @Override
    public void deleteById(Long id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.remove(session.get(Specialty.class, id));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Specialty update(Specialty specialty) {
        insert(specialty);
        return specialty;
    }

}
