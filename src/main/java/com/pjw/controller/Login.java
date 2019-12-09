package com.pjw.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Login {
    @PostMapping("/login-success")
    public String loginSuccess(){
        return "loginSuccess";
    }

    @GetMapping("/login-page")
    public String loginPage(){
        return "loginPage";
    }

    @PostMapping("/login-process")
    public String loginProcess(){
        return "loginProcess";
    }
}
