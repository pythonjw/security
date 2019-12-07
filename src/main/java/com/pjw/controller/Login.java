package com.pjw.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Login {
    @GetMapping("/login-success")
    public String loginSuccess(){
        return "success";
    }
}
