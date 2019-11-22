package com.mbste.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
@RequestMapping("/public/heroku")
public class Heroku
{
    @RequestMapping("")
    public String hello(){
        return "vip man";
    }
}
