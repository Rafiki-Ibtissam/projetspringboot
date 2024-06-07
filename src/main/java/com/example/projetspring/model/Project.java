package com.example.projetspring.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double budget;

    @ManyToMany
    @JoinTable(
            name = "project_employe",
            joinColumns = @JoinColumn(name = "project_id"),
            inverseJoinColumns = @JoinColumn(name = "employe_id")
    )
    private List<Employe> employees;

    public Project() {
    }

    public Project(String name, double budget) {
        this.name = name;
        this.budget = budget;
    }
}
