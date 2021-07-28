package com.zemoso.controller;

import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.stereotype.Controller
public class Controller {
    @GetMapping("/")
    public String showHome(){
        return "home";
    }
    @GetMapping("/managers")
    public String showManagerPage(){
        return "managers";
    }
    @GetMapping("/admins")
    public String showAdminPage(){
        return "admins";
    }
}
