package com.home.JWTuserlogin.controller;

import com.home.JWTuserlogin.model.entity.DTO.LoginResponseDTO;
import com.home.JWTuserlogin.model.entity.DTO.RegistrationUserDTO;
import com.home.JWTuserlogin.model.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin("*")
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/register")
    public String registerUser(@RequestBody RegistrationUserDTO info){

        authenticationService.registerUser(info.getUsername(),info.getPassword());
        return "Registration is Successfully";
    }

    @PostMapping("/login")
    public LoginResponseDTO loginUser(@RequestBody RegistrationUserDTO info){
        return authenticationService.loginUser(info.getUsername(),info.getPassword());
    }
}
