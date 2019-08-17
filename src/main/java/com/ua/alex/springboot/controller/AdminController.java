package com.ua.alex.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping(value = "/admin")
@Controller
public class AdminController {


    @RequestMapping(value = "/admin")
    public String adminPage() {
        return "admin";
    }
}

