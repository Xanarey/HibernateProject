package com.repository.hibernate;

import com.model.Skill;
import com.repository.SkillRepo;
import com.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class HibernateSkillRepoImpl implements SkillRepo {

    @Override
    public List<Skill> getAll() {
        Session session = HibernateUtil.getSession();
        List<Skill> skillList = session.createQuery("FROM Skill", Skill.class).list();
        session.close();
        return skillList;
    }

    @Override
    public Skill getById(Long id) {
        Session session = HibernateUtil.getSession();
        Skill skill = session.get(Skill.class, id);
        session.close();
        return skill;
    }

    @Override
    public Skill insert(Skill skill) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.persist(skill);
        session.getTransaction().commit();
        session.close();
        return skill;
    }

    @Override
    public void deleteById(Long id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        Skill skill = session.get(Skill.class, id);
        session.delete(skill);
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Skill update(Skill skill) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.update(skill);
        session.getTransaction().commit();
        session.close();
        return skill;
    }

}
