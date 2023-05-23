package ru.skypro.hw2.course4.hw2course4.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping

public class FirstController {

    @GetMapping
    public String sayMeHello() {
       return  "Hello world";
    }
}
