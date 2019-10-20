package com.carlos.studyArchUnit.controller;

import com.carlos.studyArchUnit.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @GetMapping("/home")
    public String home() {
        return "Hello Spring Boot!";
    }

    @GetMapping
    public String hello() {
        return helloService.home();
    }

}
