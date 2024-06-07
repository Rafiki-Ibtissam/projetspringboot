package com.example.projetspring.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

    @GetMapping("/demo")
    public ResponseEntity<String> demo(){
        return ResponseEntity.ok("Hello from a secret url !");
    }

    @GetMapping("/admin_only")
    public ResponseEntity<String> adminOnly(){
        return ResponseEntity.ok("Hello from admin only url");
    }
}
