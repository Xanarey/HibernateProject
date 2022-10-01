package com.model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "skills")
public class Skill {

    @Id
    @GeneratedValue(generator = "increment")
    private Long id;
    @Column(name = "name")
    private String name;

    @ManyToMany(targetEntity = Developer.class, mappedBy = "skills", cascade = CascadeType.ALL)
    private List<Skill> skills = new ArrayList<>();

    public Skill() {
    }

    public Skill(String name) {
        this.name = name;
    }

    public Skill(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Skill{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Skill)) return false;
        Skill skill = (Skill) o;
        return Objects.equals(getId(), skill.getId()) && Objects.equals(getName(), skill.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName());
    }
}
