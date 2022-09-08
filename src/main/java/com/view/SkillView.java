package com.view;

import com.controller.SkillController;
import com.model.Skill;

public class SkillView {

    SkillController skillController = new SkillController();

    public void getSkillById(Long id) {
        Skill skills = skillController.getSkillById(id);
        System.out.println("ID:   " + skills.getId());
        System.out.println("Name: " + skills.getName());
        System.out.println("==========");
    }

    public void getAllSkills() {
        for (Skill d: skillController.getAllSkills()) {
            System.out.println("ID:   " + d.getId());
            System.out.println("Name: " + d.getName());
            System.out.println("==========");
        }
    }

    public void deleteSkillById(Long id) {
        skillController.deleteById(id);
        System.out.println("Скилл удален");
    }

    public void updateSkill(Long id, String name) {
        Skill skill = skillController.getSkillById(id);
        skill.setName(name);
        skillController.update(skill);
    }

    public void insertSkill(String name) {
        Skill skill = new Skill(name);
        skillController.insert(skill);
    }

}
