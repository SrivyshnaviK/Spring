package com.zemoso.springboot.rest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import java.time.LocalDateTime;

@org.springframework.web.bind.annotation.RestController
public class RestController {
    @Value("${coach.name}")
    private String coachName;
    @Value(("${team.name}"))
    private String teamName;
    @GetMapping("/")
    public String sayHello(){
        return "Hello World!! Time on server is:"+ LocalDateTime.now();
    }
    @GetMapping("/hello")
    public String sayWorld(){
        return "World!!!";
    }
    @GetMapping("/teamInfo")
    public String getTeamInfo(){
        return "Coach:"+coachName+" Team:"+teamName;
    }
}
