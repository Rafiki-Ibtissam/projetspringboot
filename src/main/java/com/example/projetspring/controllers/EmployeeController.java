package com.example.projetspring.controllers;

import com.example.projetspring.model.Employe;
import com.example.projetspring.model.Project;
import com.example.projetspring.service.EmployeService;
import com.example.projetspring.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/manager")
public class EmployeeController {

    @Autowired
    private EmployeService employeService;
    @Autowired
    private ProjectService projectService;

    @Secured("ROLE_MANAGER")
    @GetMapping("/assign")
    public String showAssignProjectPage(Model model) {
        List<Project> projects = projectService.getAllProjects();
        List<Employe> employees = projectService.getAllEmployees();

        model.addAttribute("projects", projects);
        model.addAttribute("employees", employees);

        return "assignProject";
    }

    @Secured("ROLE_MANAGER")
    @PostMapping("/assign")
    public String assignProjectToEmployee(@RequestParam Long projectId, @RequestParam int employeId, Model model) {
        boolean success = projectService.assignProjectToEmployee(projectId, employeId);

        if (success) {
            model.addAttribute("message", "Project assigned successfully!");
        } else {
            model.addAttribute("error", "Error assigning project!");
        }

        return "redirect:/manager/assign";
    }



    @Secured({"ROLE_MANAGER", "ROLE_TECH_LEAD"})
    @GetMapping("/list")
    public String listEmployees(Model model) {
        List<Employe> employees = employeService.getAllEmployees();
        model.addAttribute("employees", employees);
        return "employeesList";
    }
}