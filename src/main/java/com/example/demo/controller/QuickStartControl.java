package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class QuickStartControl {

    @RequestMapping("/quick")
    @ResponseBody
    public String quick(){
        return "Welcome to InkBook";
    }
}
