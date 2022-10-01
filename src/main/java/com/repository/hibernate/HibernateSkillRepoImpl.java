package com.repository.hibernate;

import com.model.Skill;
import com.repository.SkillRepo;
import com.utils.HibernateUtil;
import org.hibernate.Session;

import java.util.List;

public class HibernateSkillRepoImpl implements SkillRepo {

    @Override
    public List<Skill> getAll() {
        return HibernateUtil.getSession().createQuery("FROM Skill", Skill.class).list();

    }

    @Override
    public Skill getById(Long id) {
        return HibernateUtil.getSession().get(Skill.class, id);
    }

    @Override
    public Skill insert(Skill skill) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.merge(skill);
        session.getTransaction().commit();
        session.close();
        return skill;
    }

    @Override
    public void deleteById(Long id) {
        Session session = HibernateUtil.getSession();
        session.beginTransaction();
        session.remove(session.get(Skill.class, id));
        session.getTransaction().commit();
        session.close();
    }

    @Override
    public Skill update(Skill skill) {
        insert(skill);
        return skill;
    }

}
