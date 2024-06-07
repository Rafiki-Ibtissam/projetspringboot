package com.example.projetspring.service;

import com.example.projetspring.model.Employe;
import com.example.projetspring.repository.EmployeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeService {
    @Autowired
    private EmployeRepository employeRepository;

    public List<Employe> getAllEmployees() {
        return employeRepository.findAll();
    }
}
