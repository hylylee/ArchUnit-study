package com.carlos.studyArchUnit.controller;

import com.carlos.studyArchUnit.service.HelloService;
import com.carlos.studyArchUnit.service.HelloServiceDecorator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("hello")
public class HelloController {

    @Autowired
    private HelloService helloService;

    @Autowired
    private HelloServiceDecorator helloServiceDecorator;

    @GetMapping("/home")
    public String home() {
        return "Hello Spring Boot!";
    }

    @GetMapping
    public String hello() {
        return helloService.home();
    }

    @GetMapping("/decorator")
    public String helloWithDecorator() {
        return helloServiceDecorator.helloWithDecorated();
    }

}
