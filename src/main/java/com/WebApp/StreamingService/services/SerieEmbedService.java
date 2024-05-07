package com.WebApp.StreamingService.services;
import com.WebApp.StreamingService.config.ApiConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class SerieEmbedService  {

    public String constructSerieEmbedUrl(String imdbId) {

        String embedUrl = UriComponentsBuilder.fromHttpUrl(ApiConfiguration.BASE_URL)
                .queryParam("imdb", imdbId)
                .toUriString();
        return embedUrl;
    }
}