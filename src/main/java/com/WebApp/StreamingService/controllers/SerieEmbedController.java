package com.WebApp.StreamingService.controllers;
import com.WebApp.StreamingService.services.SerieEmbedService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
@AllArgsConstructor
@RestController
@CrossOrigin(origins="*")
@RequestMapping("/series")
public class SerieEmbedController {

    private final SerieEmbedService serieEmbedService;

    @GetMapping("/embed")
    public ResponseEntity<String> getSerieEmbedUrl(@RequestParam String imdbId) {

        String embedUrl = serieEmbedService.constructSerieEmbedUrl(imdbId);
        return ResponseEntity.ok(embedUrl);
    }

}