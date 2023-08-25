package com.home.JWTuserlogin.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class publicController {

    @GetMapping("/v1")
    public String api(){
        return "this is api of our service - V1";
    }

}
