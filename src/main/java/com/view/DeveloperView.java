package com.view;

import com.controller.DeveloperController;
import com.model.Developer;

public class DeveloperView {

    DeveloperController developerController = new DeveloperController();

    public void getAllDeveloper() {
        for (Developer d: developerController.getAllDeveloper()) {
            System.out.println("ID:           " + d.getId());
            System.out.println("FirstName:    " + d.getFirstName());
            System.out.println("LastName:     " + d.getLastName());
            System.out.println("Status:       " + d.getStatus());
        }
    }

}