package com.WebApp.StreamingService.controllers;


import com.WebApp.StreamingService.services.MovieEmbedService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@AllArgsConstructor
@RestController

@RequestMapping("/movies")
public class MovieEmbedController {

    private final MovieEmbedService movieEmbedService;

    @GetMapping("/embed/{imdbId}")
    public ResponseEntity<String> getMovieEmbedUrl(@PathVariable String imdbId) {
        String embedUrl = movieEmbedService.constructMovieEmbedUrl(imdbId);
        return ResponseEntity.ok(embedUrl);
    }

}