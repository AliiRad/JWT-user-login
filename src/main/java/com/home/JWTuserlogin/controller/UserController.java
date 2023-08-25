package com.home.JWTuserlogin.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @GetMapping("/validate")
    public String validateUser(){
        System.out.println("I'm in user validate method");
        return "You are in user access level";
    }
}
