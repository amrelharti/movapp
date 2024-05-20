package com.WebApp.StreamingService.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/welcome")
public class LandingPage {

    @GetMapping
    public String home(){
        return "landingPage";  // Ensure you have a Thymeleaf template named 'landingPage.html' under 'src/main/resources/templates'
    }
}
