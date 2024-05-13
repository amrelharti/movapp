package com.WebApp.StreamingService.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ApiConfiguration implements WebMvcConfigurer {
    public static final String BASE_URL = "https://vidsrc.xyz/embed/movie";
    public static final String IMDB_API_KEY = "2fa0c86253msh27c51dc8cf35e30p154ddejsnf23dbb811fa1";
    public static final String IMDB_API_HOST = "moviesminidatabase.p.rapidapi.com";
    public static final String IMDB_API_URL = "https://moviesminidatabase.p.rapidapi.com";

    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    // Example method to call the "moviesminidatabase" API
    public String getMovieById(String movieId) {
        String url = IMDB_API_URL + "/movie/id/" + movieId + "/";

        HttpHeaders headers = new HttpHeaders();
        headers.set("X-RapidAPI-Key", IMDB_API_KEY);
        headers.set("X-RapidAPI-Host", IMDB_API_HOST);

        HttpEntity<String> entity = new HttpEntity<>(headers);

        ResponseEntity<String> response = restTemplate().exchange(url, HttpMethod.GET, entity, String.class);

        if (response.getStatusCode().is2xxSuccessful()) {
            return response.getBody();
        } else {
            // Handle unsuccessful response or error
            return "Error: Unable to fetch movie details";
        }
    }


}
