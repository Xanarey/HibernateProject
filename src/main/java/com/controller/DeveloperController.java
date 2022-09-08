package com.controller;

import com.model.Developer;
import com.model.Status;
import com.service.DeveloperService;

import java.util.List;

public class DeveloperController {

    private final DeveloperService developerService;

    public DeveloperController() {
        this.developerService = new DeveloperService();
    }

    public DeveloperController(DeveloperService developerService) {
        this.developerService = developerService;
    }

    public List<Developer> getAllDeveloper() {
        return developerService.getAll();
    }

    public Developer getDeveloperById(Long id) {return developerService.getDeveloperById(id);}

    public Developer insert(Developer developer) {
        return developerService.insert(developer);
    }

    public void deleteById(Long id) {
        developerService.deleteById(id);
    }

    public void changeStatusOnDeleted(Long id) {
        Developer developer = developerService.getDeveloperById(id);
        developer.setStatus(Status.DELETED);
        developerService.update(developer);
    }

    public Developer update(Developer developer) {
        developerService.update(developer);
        return developer;
    }
}
