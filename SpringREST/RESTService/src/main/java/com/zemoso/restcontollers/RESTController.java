package com.zemoso.restcontollers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest")
public class RESTController {
    @GetMapping("/hello")
    public String sayHello(){
        return "Hello World of REST Services!!!";
    }
}
