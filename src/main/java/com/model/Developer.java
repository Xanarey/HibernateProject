package com.model;

import java.util.List;

public class Developer {
    private Long id;
    private String firstName;
    private String lastName;
    private Status status;
    private Specialty specialty;
    private List<Skill> skills;

    public Developer() {}

    public Developer(String firstName, String lastName, Status status, Specialty specialty, List<Skill> skills) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
        this.specialty = specialty;
        this.skills = skills;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Specialty getSpecialty() {
        return specialty;
    }

    public void setSpecialty(Specialty specialty) {
        this.specialty = specialty;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", status=" + status +
                ", specialty=" + specialty +
                ", skills=" + skills +
                '}';
    }
}
