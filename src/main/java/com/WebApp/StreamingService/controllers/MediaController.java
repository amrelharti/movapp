package com.WebApp.StreamingService.controllers;

import com.WebApp.StreamingService.services.MediaService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;

@AllArgsConstructor
@CrossOrigin(origins="*")
@Controller
public class MediaController {
private MediaService mediaService;
@RequestMapping("/createMedia")
    public String createMedia(){
        return "CreateMedia";
}
}
