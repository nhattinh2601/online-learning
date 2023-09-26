package com.example.onlinelearning;/*
Created on 9/26/2023  12:26 PM 2023

@author: tinh2

ProjectName: online-learning
*/


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
    @RequestMapping("/")
    public String Hello(){
        return "Hello World";
    }
}
