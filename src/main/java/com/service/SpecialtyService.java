package com.service;


import com.model.Specialty;
import com.repository.SpecialtyRepo;
import com.repository.hibernate.HibernateSpecRepoImpl;

import java.util.List;

public class SpecialtyService {

    private final SpecialtyRepo specialtyRepo = new HibernateSpecRepoImpl();

    public List<Specialty> getAll() {
        return specialtyRepo.getAll();
    }

    public Specialty getSpecialtyById(Long id) {
        return specialtyRepo.getById(id);
    }

    public Specialty insert(Specialty specialty) {
        return specialtyRepo.insert(specialty);
    }

    public void deleteById(Long id) {
        specialtyRepo.deleteById(id);
    }

    public Specialty update(Specialty specialty) {
        return specialtyRepo.update(specialty);
    }

}
