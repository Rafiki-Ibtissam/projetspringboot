package com.example.projetspring.repository;

import com.example.projetspring.model.Employe;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeRepository extends JpaRepository<Employe,Integer> {


    Optional<Employe> findByUsername(String username);
}
