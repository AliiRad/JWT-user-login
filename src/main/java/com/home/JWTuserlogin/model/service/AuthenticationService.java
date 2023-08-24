package com.home.JWTuserlogin.model.service;

import com.home.JWTuserlogin.model.entity.Role;
import com.home.JWTuserlogin.model.entity.User;
import com.home.JWTuserlogin.model.repository.RoleRepository;
import com.home.JWTuserlogin.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public User registerUser(String username,String password){
        String encodedPassword = passwordEncoder.encode(password);
        Role userRole = roleRepository.findByAuthority("USER").get();

        Set<Role> authorities = new HashSet<>();
        authorities.add(userRole);

        return userRepository.save(new User(username,encodedPassword,authorities));
    }
}
