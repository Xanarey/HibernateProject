package com.view;

import com.controller.SpecialtyController;
import com.model.Specialty;

public class SpecialtyView {

    SpecialtyController specialtyController = new SpecialtyController();

    public void getSpecialtyById(Long id) {
        Specialty specialty = specialtyController.getSpecialtyById(id);
        System.out.println("ID:   " + specialty.getId());
        System.out.println("Name: " + specialty.getName());
        System.out.println("==========");
    }

    public void getAllSpecialty() {
        for (Specialty d: specialtyController.getAllSpecialty()) {
            System.out.println("ID:   " + d.getId());
            System.out.println("Name: " + d.getName());
            System.out.println("==========");
        }
    }

    public void deleteSpecialtyById(Long id) {
        specialtyController.getSpecialtyById(id);
        System.out.println("Специальность удалена");
        specialtyController.deleteById(id);
    }

    public void updateSpecialty(Long id, String name) {

    }

    public void insertSpecialty(String name) {

    }

}
