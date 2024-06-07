package com.example.projetspring.service;


import com.example.projetspring.repository.EmployeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailsImpl implements UserDetailsService {
    @Autowired
    private EmployeRepository employeRepository ;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        return employeRepository.findByUsername(username).orElseThrow(()->new UsernameNotFoundException("User not found !"));
    }
}
