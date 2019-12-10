package com.pjw.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

    @GetMapping("/get-user")
    public String getUser(){
        String userName=null;
        //当前认证通过的用户身份
        Authentication authentication= SecurityContextHolder.getContext().getAuthentication();
        //用户身份
        Object principal=authentication.getPrincipal();
        if(principal==null){
            userName="游客";
        }
        if(principal instanceof org.springframework.security.core.userdetails.UserDetails){
            UserDetails userDetails=(UserDetails) principal;
            userName=userDetails.getUsername();
        }else{
            userName=principal.toString();
        }
        return userName;
    }
}
