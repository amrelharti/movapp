package com.WebApp.StreamingService.controllers;

import com.WebApp.StreamingService.entities.Movie;
import com.WebApp.StreamingService.services.ImdbService;
import com.WebApp.StreamingService.services.MovieEmbedService;
import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/movies")
public class MovieController {

    private final ImdbService imdbService;
    private final MovieEmbedService movieEmbedService;

    @Autowired
    public MovieController(ImdbService imdbService,MovieEmbedService movieEmbedService) {
        this.imdbService = imdbService;
        this.movieEmbedService=movieEmbedService;
    }

    @GetMapping
    public String listMovies(Model model, @RequestParam(defaultValue = "1") int page) {
        List<Movie> movies = imdbService.fetchMoviesByCategory("popular", page);
        model.addAttribute("movies", movies);
        model.addAttribute("currentPage", page);
        return "movielist";
    }
    @GetMapping("/details/{imdbId}")
    public String showMovieDetails(@PathVariable("imdbId") String imdbId, Model model) {
        Movie movie = imdbService.findMovieById(imdbId);
        System.out.println("Retrieved movie: " + movie);  // Log the movie details
        if (movie == null) {
            return "errorPage";  // Redirect to an error page if the movie is null
        }
        model.addAttribute("movie", movie);
        System.out.println("Movie Title: " + movie.getTitle());
        System.out.println("Movie ID: " + movie.getImdbId());
        return "movieDetails";

    }
    @GetMapping("/search")
    public String searchMovies(@RequestParam("query") String query, Model model) {
        List<Movie> movies = imdbService.searchMovies(query);
        model.addAttribute("movies", movies);
        return "searchedMovies";  // Ensure this view is properly set up to show results
    }

@GetMapping("/")
    public String home(){
        return "redirect:/movielist";
}



}