package com.example.projetspring.controllers;

import com.example.projetspring.model.Employe;
import com.example.projetspring.service.EmployeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeRestController {

    @Autowired
    private EmployeService employeService;

    @Secured({"ROLE_DEV", "ROLE_TEST", "ROLE_DEVOPS"})
    @GetMapping("/list")
    public List<Employe> listEmployees() {
        return employeService.getAllEmployees();
    }
}
