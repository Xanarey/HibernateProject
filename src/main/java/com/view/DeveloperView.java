package com.view;

import com.controller.DeveloperController;
import com.controller.SkillController;
import com.controller.SpecialtyController;
import com.model.Developer;
import com.model.Skill;
import com.model.Specialty;
import com.model.Status;

import java.util.ArrayList;
import java.util.List;

public class DeveloperView {

    DeveloperController developerController = new DeveloperController();
    SkillController skillController = new SkillController();
    SpecialtyController specialtyController = new SpecialtyController();

    public void getAllDeveloper() {
        for (Developer d: developerController.getAllDeveloper()) {
            System.out.println("=================================");
            System.out.println("ID:           " + d.getId());
            System.out.println("FirstName:    " + d.getFirstname());
            System.out.println("LastName:     " + d.getLastname());
            System.out.println("Status:       " + d.getStatus());
            System.out.println("Specialty:    " + d.getSpecialty().getName());
            System.out.println("Skills:       " + d.getSkills());
        }
    }

    public void getDeveloperById(Long id) {
        System.out.println("=================================");
        Developer d = developerController.getDeveloperById(id);
        System.out.println("ID:           " + d.getId());
        System.out.println("FirstName:    " + d.getFirstname());
        System.out.println("LastName:     " + d.getLastname());
        System.out.println("Status:       " + d.getStatus());
        System.out.println("Specialty:    " + d.getSpecialty().getName());
        System.out.println("Skills:       " + d.getSkills());
    }

    public void insert(Developer developer) {
        System.out.println("=================================");
        List<Skill> skillList = new ArrayList<>();
        Skill skill = skillController.getSkillById(developer.getSkills().get(0).getId());
        skillList.add(skill);
        developer.setSkills(skillList);
        Specialty specialty = specialtyController.getSpecialtyById(developer.getSpecialty_id());
        developer.setSpecialty(specialty);
        developerController.insert(developer);
        System.out.println("FirstName:    " + developer.getFirstname());
        System.out.println("LastName:     " + developer.getLastname());
        System.out.println("Разработчик успешно добавлен");
    }

    public void delete(Long id) {
        developerController.deleteById(id);
        System.out.println("Пользователь с ID: " + id + " удален");
    }

    public void updateDeveloper (Long id, String firstName, String lastName, Long specialty) {
        Developer developer = developerController.getDeveloperById(id);
        developer.setFirstname(firstName);
        developer.setLastname(lastName);
        developer.setStatus(Status.ACTIVE);
        developer.setSpecialty_id(specialty);
        developerController.update(developer);
        System.out.println("Данные о разработчике обновлены");
    }

    public void changeStatus(Long id) {
        developerController.changeStatusOnDeleted(id);
        System.out.println("Статус пользователя с ID: " + id + " изменен");
    }
}
