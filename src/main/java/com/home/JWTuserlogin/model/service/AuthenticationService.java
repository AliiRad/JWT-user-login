package com.home.JWTuserlogin.model.service;

import com.home.JWTuserlogin.model.entity.DTO.LoginResponseDTO;
import com.home.JWTuserlogin.model.entity.Role;
import com.home.JWTuserlogin.model.entity.User;
import com.home.JWTuserlogin.model.repository.RoleRepository;
import com.home.JWTuserlogin.model.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
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
    private final TokenService tokenService;
    private final AuthenticationManager authManager;

    public User registerUser(String username,String password){
        String encodedPassword = passwordEncoder.encode(password);
        Role userRole = roleRepository.findByAuthority("USER").get();

        Set<Role> authorities = new HashSet<>();
        authorities.add(userRole);

        return userRepository.save(new User(username,encodedPassword,authorities));
    }

    public LoginResponseDTO loginUser(String username,String password){
        try {
            Authentication auth = authManager.authenticate(
                    new UsernamePasswordAuthenticationToken(username,password)
            );

            String token = tokenService.generateJwtToken(auth);

            User user = userRepository.findByUsername(username).get();

            return new LoginResponseDTO(user,token);

        }catch (AuthenticationException e){
            return new LoginResponseDTO(null,"");
        }
    }


}
