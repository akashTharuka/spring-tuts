package com.tuts.springTuts.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    @GetMapping("/")
    public String greet() {
        return "Hello World!!!";
    }

    @GetMapping("/about")
    public String about() {
        return "This is a simple Spring Boot application.";
    }
}
