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

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }


}
