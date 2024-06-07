package com.example.projetspring.service;


import com.example.projetspring.model.Employe;
import com.example.projetspring.repository.EmployeRepository;
import com.example.projetspring.response.AuthenticationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    @Autowired
    private final EmployeRepository employeRepository;
    @Autowired
    private final JwtService jwtService;
    @Autowired
    private final PasswordEncoder passwordEncoder;
    @Autowired
    private AuthenticationManager authenticationManager;

    public AuthenticationResponse register(Employe request){
        Employe employe=new Employe();
        employe.setName(request.getName());
        employe.setEmail(request.getEmail());
        employe.setSkills(request.getSkills());
        employe.setPassword(passwordEncoder.encode(request.getPassword()));
        employe.setPost(request.getPost());
        employe=employeRepository.save(employe);
       String token =jwtService.generateToken(employe);
       return new AuthenticationResponse(token);

    }

    public AuthenticationResponse authenticate(Employe request){
      authenticationManager.authenticate(
             new UsernamePasswordAuthenticationToken(
                      request.getName(),
                      request.getPassword()
              )
      );

      Employe user=employeRepository.findByUsername(request.getName()).orElseThrow();
      String token=jwtService.generateToken(employe);
      return new AuthenticationResponse(token);

    }


}
