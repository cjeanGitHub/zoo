package com.cjean.zoo.applications.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by kemp on 2018/8/15.
 */
@Controller
public class MyController {

    @RequestMapping("/login")
    public String login(){
        return "index-01";
    }

    @RequestMapping("/login2")
    public String login2(){
        return "index-02";
    }

    @RequestMapping("/login3")
    public String login3(){
        return "index-thymleaf";
    }

    @RequestMapping("/login4")
    public String login4(){
        return "ruozhi/login222.html";
    }

    @RequestMapping("/webSocket")
    public String webSocket(){
        return "webSocket";
    }
}