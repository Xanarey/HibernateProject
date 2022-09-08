package com.controller;

import com.model.Skill;
import com.service.SkillService;

import java.util.List;

public class SkillController {


    private final SkillService skillService;

    public SkillController() {
        this.skillService = new SkillService();
    }

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    public List<Skill> getAllSkills() {
        return skillService.getAll();
    }

    public Skill getSkillById(Long id) {return skillService.getById(id);}

    public Skill insert(Skill skill) {
        return skillService.insert(skill);
    }

    public void deleteById(Long id) {
        skillService.deleteById(id);
    }

    public Skill update(Skill skill) {
        return skillService.update(skill);
    }

}
