package com.WebApp.StreamingService.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {
    @GetMapping("/")
    public String movie(){
        return "redirect:/movies";
    }


}
