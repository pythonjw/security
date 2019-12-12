package com.pjw.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloController {
    @GetMapping("/h1")
    //@PreAuthorize("hasAnyAuthority('p1','p3')")//拥有p1或p3权限才可以访问
   // @PreAuthorize("hasAuthority('p1')")//拥有p1权限才可以访问
    //@PreAuthorize("hasAuthority('p1') and hasAuthority('p2')")//拥有p1和p2权限才可以访问
    public String hello1(){
        return "h1";
    }
}
