package com.example.projetspring.service;

import com.example.projetspring.model.Employe;
import com.example.projetspring.model.Project;
import com.example.projetspring.repository.EmployeRepository;
import com.example.projetspring.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProjectService {


    @Autowired
    private ProjectRepository projectRepository;

    @Autowired
    private EmployeRepository employeRepository;

    public List<Project> getAllProjects() {
        return projectRepository.findAll();
    }

    public List<Employe> getAllEmployees() {
        return employeRepository.findAll();
    }

    public boolean assignProjectToEmployee(Long projectId, int employeId) {
        Optional<Project> projectOpt = projectRepository.findById(projectId);
        Optional<Employe> employeOpt = employeRepository.findById(employeId);

        if (projectOpt.isPresent() && employeOpt.isPresent()) {
            Project project = projectOpt.get();
            Employe employe = employeOpt.get();
            project.getEmployees().add(employe);
            projectRepository.save(project);
            return true;
        }

        return false;
    }
}

