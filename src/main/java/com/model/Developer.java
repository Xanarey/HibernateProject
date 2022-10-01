package com.model;

import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "developers", schema = "postgres")
public class Developer {

    @Id @GeneratedValue(generator = "increment")
    private Long id;
    @Column(name = "firstname")
    private String firstname;
    @Column(name = "lastname")
    private String lastname;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name = "specialty_id")
    private Long specialty_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "specialty_id", insertable = false, updatable = false)
    private Specialty specialty;

    @ManyToMany(fetch = FetchType.LAZY, targetEntity = Skill.class, cascade = CascadeType.ALL)
    @JoinTable(name = "developers_skills",
            joinColumns =
            @JoinColumn(name = "developers_id"),
            inverseJoinColumns =
            @JoinColumn(name = "skills_id")
    )
    private List<Skill> skills;

    public Developer() {}

    public Developer(String firstname, String lastname, Status status, Long specialty_id, Specialty specialty, List<Skill> skills) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.status = status;
        this.specialty_id = specialty_id;
        this.specialty = specialty;
        this.skills = skills;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Long getSpecialty_id() {
        return specialty_id;
    }

    public void setSpecialty_id(Long specialty_id) {
        this.specialty_id = specialty_id;
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
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                ", status=" + status +
                ", specialty_id=" + specialty_id +
                ", specialty=" + specialty +
                ", skills=" + skills +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Developer developer = (Developer) o;
        return Objects.equals(id, developer.id) && Objects.equals(firstname, developer.firstname) && Objects.equals(lastname, developer.lastname) && status == developer.status && Objects.equals(specialty_id, developer.specialty_id) && Objects.equals(specialty, developer.specialty) && Objects.equals(skills, developer.skills);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, status, specialty_id, specialty, skills);
    }
}