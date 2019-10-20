package com.carlos.studyArchUnit.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public String home() {
        return "Hello, this is HelloService";
    }

}
