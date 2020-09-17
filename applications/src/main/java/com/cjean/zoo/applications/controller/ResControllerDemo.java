package com.cjean.zoo.applications.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ResControllerDemo {

    @RequestMapping("/recomplite")
    public String recomplite(){
//        return "recomplite";
        System.out.println("33333333");
        return "recomplite   333333   ";
    }
}
