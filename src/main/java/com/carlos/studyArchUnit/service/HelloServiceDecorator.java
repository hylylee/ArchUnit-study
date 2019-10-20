package com.carlos.studyArchUnit.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloServiceDecorator {

    @Autowired
    HelloService helloService;

    public String helloWithDecorated() {
        return helloService.home() + "(Decorator)";
    }

}
