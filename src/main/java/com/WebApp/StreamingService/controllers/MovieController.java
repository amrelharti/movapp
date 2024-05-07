package com.WebApp.StreamingService.controllers;

import com.WebApp.StreamingService.services.ImdbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {

    private final ImdbService imdbService;

    @Autowired
    public MovieController(ImdbService imdbService) {
        this.imdbService = imdbService;
    }

    @GetMapping
    public String listMovies(Model model) {
        List<ImdbService.Movie> movies = imdbService.fetchAllMovies();
        model.addAttribute("movies", movies);
        return "movielist";
    }
}
