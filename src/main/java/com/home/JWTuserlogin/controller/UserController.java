package com.home.JWTuserlogin.controller;

import com.home.JWTuserlogin.model.entity.User;
import com.home.JWTuserlogin.model.service.AuthenticationService;
import com.home.JWTuserlogin.model.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final AuthenticationService authenticationService;
    private final PasswordEncoder passwordEncoder;

    @GetMapping("/test")
    public String test() {
        return "hello";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam("username") String username ,
                               @RequestParam("password") String password){

        authenticationService.registerUser(User.builder()
                .username(username)
                .password(password)
                .build());
        return "SuccessRegistrationPage";
    }
}
