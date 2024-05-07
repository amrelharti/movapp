package com.WebApp.StreamingService.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ImdbService {

    @Value("${moviedb.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    public List<Movie> fetchAllMovies() {
        String[] categories = { "popular", "now_playing", "upcoming", "top_rated" };
        return List.of(categories).stream()
                .flatMap(category -> fetchMoviesByCategory(category).stream())
                .collect(Collectors.toList());
    }

    private List<Movie> fetchMoviesByCategory(String category) {
        String url = String.format("https://api.themoviedb.org/3/movie/%s?api_key=%s", category, apiKey);
        Map<String, Object> response = restTemplate.getForObject(url, Map.class);
        List<Map<String, Object>> results = (List<Map<String, Object>>) response.get("results");
        return results.stream()
                .map(result -> new Movie(
                        (String) result.get("title"),
                        "https://image.tmdb.org/t/p/w500" + result.get("poster_path")
                ))
                .collect(Collectors.toList());
    }

    public static class Movie {
        private String title;
        private String posterPath;

        public Movie(String title, String posterPath) {
            this.title = title;
            this.posterPath = posterPath;
        }

        public String getTitle() {
            return title;
        }

        public String getPosterPath() {
            return posterPath;
        }
    }
}
