package com.home.JWTuserlogin.controller;

import com.home.JWTuserlogin.model.entity.DTO.RegistrationUserDTO;
import com.home.JWTuserlogin.model.entity.User;
import com.home.JWTuserlogin.model.service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
@CrossOrigin("*")
public class UserController {


    private final AuthenticationService authenticationService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/test")
    public String test() {
        return "hello";
    }

    @GetMapping("/test1")
    public String test1() {
        return "test1 , hello";
    }
    @PostMapping("/register")
    public String registerUser(@RequestBody RegistrationUserDTO info){

        authenticationService.registerUser(info.getUsername(),info.getPassword());
        return "Registration is Successfully";
    }
}
