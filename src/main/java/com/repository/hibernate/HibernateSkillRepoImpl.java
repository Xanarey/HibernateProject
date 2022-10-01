package com.repository.hibernate;

import com.model.Skill;
import com.repository.SkillRepo;
import com.utils.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Collections;
import java.util.List;

public class HibernateSkillRepoImpl implements SkillRepo {

    @Override
    public List<Skill> getAll() {
        try (Session session = HibernateUtil.getSession()){
            return session.createQuery("FROM Skill", Skill.class).list();
        } catch (Throwable t) {
            return Collections.emptyList();
        }
    }

    @Override
    public Skill getById(Long id) {
        try (Session session = HibernateUtil.getSession()) {
            return session.get(Skill.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new Skill();
    }

    @Override
    public Skill insert(Skill skill) {
        Transaction transaction = null;
        try (Session session = HibernateUtil.getSession()){
            transaction = session.beginTransaction();
            session.merge(skill);
            transaction.commit();
        } catch (Exception e) {
            if (transaction != null)
                transaction.rollback();
        }
        return skill;
    }

    @Override
    public void deleteById(Long id) {
        try (Session session = HibernateUtil.getSession()){
            session.beginTransaction();
            session.remove(session.get(Skill.class, id));
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public Skill update(Skill skill) {
        insert(skill);
        return skill;
    }

}
