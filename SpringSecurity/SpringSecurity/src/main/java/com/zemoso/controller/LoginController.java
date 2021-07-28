package com.zemoso.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping("/showLoginPage")
    public String showLoginPage(){
        return "bootstrapLogin";
    }
    @GetMapping("/accessDeniedPage")
    public String showAccessDeniedPage(){
        return "accessDenied";
    }
}
