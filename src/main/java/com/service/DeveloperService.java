package com.service;

import com.model.Developer;
import com.repository.DeveloperRepo;
import com.repository.hibernate.HibernateDevRepoImpl;

import java.util.List;

public class DeveloperService {

    private final DeveloperRepo developerRepo = new HibernateDevRepoImpl();

    public List<Developer> getAll() {
        return developerRepo.getAll();
    }

    public Developer getDeveloperById(Long id) {
        return developerRepo.getById(id);
    }

    public Developer insert(Developer developer) {
        return developerRepo.insert(developer);
    }

    public void deleteById(Long id) {
        developerRepo.deleteById(id);
    }

    public Developer update(Developer developer) {
        return developerRepo.update(developer);
    }
}
