package com.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "developer")
public class Developer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "firstName")
    private String firstName;
    @Column(name = "lastName")
    private String lastName;
    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;
    @Column(name = "specialty_id")
    private Long specialty_id;

    @ManyToOne
    @JoinColumn(name = "specialty_id", referencedColumnName = "id", insertable = false, updatable = false)
    private Specialty specialty;


    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "id", referencedColumnName = "id", insertable = false, updatable = false)
    private List<Skill> skillList;

    public Developer() {
    }

    public Developer(String firstName, String lastName, Status status, Long specialty_id, Specialty specialty, List<Skill> skillList) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
        this.specialty_id = specialty_id;
        this.specialty = specialty;
        this.skillList = skillList;
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

    public void setLastName(String lastName) {this.lastName = lastName;}

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

    public Specialty getSpecialty() {return specialty;}

    public void setSpecialty(Specialty specialty) {this.specialty = specialty;}

    public List<Skill> getSkillList() {return skillList;}

    public void setSkillList(List<Skill> skillList) {this.skillList = skillList;}

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", status=" + status +
                ", specialty_id=" + specialty_id +
                ", specialty=" + specialty +
                ", skillList=" + skillList +
                '}';
    }
}
