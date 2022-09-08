package com.controller;

import com.model.Specialty;
import com.service.SpecialtyService;

import java.util.List;

public class SpecialtyController {

    private final SpecialtyService specialtyService;

    public SpecialtyController() {
        this.specialtyService = new SpecialtyService();
    }

    public SpecialtyController(SpecialtyService specialtyService) {
        this.specialtyService = specialtyService;
    }

    public List<Specialty> getAllSpecialty() {
        return specialtyService.getAll();
    }

    public Specialty getSpecialtyById(Long id) {return specialtyService.getSpecialtyById(id);}

    public Specialty insert(Specialty specialty) {
        return specialtyService.insert(specialty);
    }

    public void deleteById(Long id) {
        specialtyService.deleteById(id);
    }

    public Specialty update(Specialty specialty) {
        specialtyService.update(specialty);
        return specialty;
    }

}
