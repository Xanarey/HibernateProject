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
}
