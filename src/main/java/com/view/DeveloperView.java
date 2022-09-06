package com.view;

import com.controller.DeveloperController;
import com.model.Developer;

public class DeveloperView {

    DeveloperController developerController = new DeveloperController();

    public void getAllDeveloper() {
        for (Developer d: developerController.getAllDeveloper()) {
            System.out.println("=================================");
            System.out.println("ID:           " + d.getId());
            System.out.println("FirstName:    " + d.getFirstName());
            System.out.println("LastName:     " + d.getLastName());
            System.out.println("Status:       " + d.getStatus());
        }
    }

    public void getDeveloperById(Long id) {
        System.out.println("=================================");
        Developer d = developerController.getDeveloperById(id);
        System.out.println("ID:           " + d.getId());
        System.out.println("FirstName:    " + d.getFirstName());
        System.out.println("LastName:     " + d.getLastName());
        System.out.println("Status:       " + d.getStatus());
    }

    public void insert() {
        System.out.println("=================================");
        Developer d = developerController.insert(new Developer());
        System.out.println("ID:           " + d.getId());
        System.out.println("FirstName:    " + d.getFirstName());
        System.out.println("LastName:     " + d.getLastName());
        System.out.println("Status:       " + d.getStatus());
        System.out.println("Разработчик успешно добавлен");
    }

    public void delete(Long id) {
        developerController.deleteById(id);
        System.out.println("Пользователь с ID: " + 34 + " удален");
    }

    public void changeStatus(Long id) {
        developerController.changeStatusOnDeleted(id);
        System.out.println("Статус пользователя с ID: " + id + " изменен");
    }
}
