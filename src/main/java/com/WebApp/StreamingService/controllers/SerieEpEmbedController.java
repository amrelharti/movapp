package com.WebApp.StreamingService.controllers;
import com.WebApp.StreamingService.services.SerieEpEmbedService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@AllArgsConstructor
@RestController
@CrossOrigin(origins="*")
@RequestMapping("/series/tv")
public class SerieEpEmbedController {

    private final SerieEpEmbedService serieEpEmbedService;

    @GetMapping("/embed")
    public ResponseEntity<String> getSerieEpEmbedUrl(@RequestParam String imdbId,int season,int episode) {

        String embedUrl = serieEpEmbedService.constructSerieEpEmbedUrl(imdbId,season,episode);
        return ResponseEntity.ok(embedUrl);
    }


}