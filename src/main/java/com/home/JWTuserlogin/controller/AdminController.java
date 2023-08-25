package com.home.JWTuserlogin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {


    @GetMapping("/validate")
    public String adminValidate(){
        System.out.println("Im in adminValidate method");
        return "You are in admin Access Level";
    }

}
