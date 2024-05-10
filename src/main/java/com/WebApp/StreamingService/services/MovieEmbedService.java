package com.WebApp.StreamingService.services;

import com.WebApp.StreamingService.config.ApiConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class MovieEmbedService {

        public String constructMovieEmbedUrl(String imdbId) {
            return "https://vidsrc.xyz/embed/movie/" + imdbId;
        }
}