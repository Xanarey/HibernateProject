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
    private String status;
    @Column(name = "specialty_id")
    private int specialty_id;

    //TODO остановился здесь
    private Specialty specialty;

    public Developer() {
    }

    public Developer(String firstName, String lastName, String status, int specialty_id) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.status = status;
        this.specialty_id = specialty_id;
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getSpecialty_id() {
        return specialty_id;
    }

    public void setSpecialty_id(int specialty_id) {
        this.specialty_id = specialty_id;
    }

    public Specialty getSpecialty() {return specialty;}

    public void setSpecialty(Specialty specialty) {this.specialty = specialty;}

    @Override
    public String toString() {
        return "Developer{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", status='" + status + '\'' +
                ", specialty_id=" + specialty_id +
                ", specialty=" + specialty +
                '}';
    }
}
