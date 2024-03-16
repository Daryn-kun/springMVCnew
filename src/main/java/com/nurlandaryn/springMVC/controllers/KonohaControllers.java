package com.nurlandaryn.springMVC.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/konoha")
public class KonohaControllers {

    @GetMapping("/heroes")
    public String getHeroes(){
        return "konoha/heroes";
    }
}
