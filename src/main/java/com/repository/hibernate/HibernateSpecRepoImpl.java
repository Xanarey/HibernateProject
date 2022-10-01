package com.repository.hibernate;

import com.model.Specialty;
import com.repository.SpecialtyRepo;
import com.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collections;
import java.util.List;

public class HibernateSpecRepoImpl implements SpecialtyRepo  {

    @Override
    public List<Specialty> getAll() {
        try (Session session = HibernateUtil.getSession()){
            return session.createQuery("FROM Specialty", Specialty.class).list();
        } catch (Throwable t) {
            return Collections.emptyList();
        }
    }

    @Override
    public Specialty getById(Long id) {
        try (Session session = HibernateUtil.getSession()){
            return session.get(Specialty.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Specialty();
    }

    @Override
    public Specialty insert(Specialty specialty) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()) {
            transaction = session.beginTransaction();
            session.merge(specialty);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
            e.printStackTrace();
        }
        return specialty;
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = HibernateUtil.getSession()){
            session.beginTransaction();
            session.remove(session.get(Specialty.class, id));
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Specialty update(Specialty specialty) {
        insert(specialty);
        return specialty;
    }

}
