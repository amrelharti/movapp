package com.WebApp.StreamingService.services;
import com.WebApp.StreamingService.config.ApiConfiguration;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

@Service
public class SerieEpEmbedService  {

    public String constructSerieEpEmbedUrl(String imdbId,int season,int episode) {

        String embedUrl = UriComponentsBuilder.fromHttpUrl(ApiConfiguration.BASE_URL)
                .queryParam("imdb", imdbId)
                .queryParam("season",season)
                .queryParam("episode",episode)
                .toUriString();
        return embedUrl;
    }
}