package com.WebApp.StreamingService.services;

import com.WebApp.StreamingService.entities.Movie;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ImdbService {


    @Value("${moviedb.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate ;


    public ImdbService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Movie findMovieById(String movieId) {
        String url = "https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey;
        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);

        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            return convertToMovie(response.getBody());
        }
        return null;
    }




    public List<Movie> fetchMoviesByCategory(String category, int page) {
        String url = UriComponentsBuilder.fromHttpUrl("https://api.themoviedb.org/3/movie/" + category)
                .queryParam("api_key", apiKey)
                .queryParam("page", page)
                .toUriString();
        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);
        if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
            List<Map<String, Object>> results = (List<Map<String, Object>>) response.getBody().get("results");
            return results.stream().map(this::convertToMovie).collect(Collectors.toList());
        }
        return Collections.emptyList();
    }


    public List<Movie> searchMovies(String query) {
        String url = UriComponentsBuilder.fromHttpUrl("https://api.themoviedb.org/3/search/movie")
                .queryParam("api_key", apiKey)
                .queryParam("query", query)
                .toUriString();

        ResponseEntity<Map> response = restTemplate.getForEntity(url, Map.class);

        if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
            return extractMovies(response.getBody());
        }
        return Collections.emptyList();
    }

    private List<Movie> extractMovies(Map<String, Object> responseBody) {
        List<Map<String, Object>> results = (List<Map<String, Object>>) responseBody.get("results");
        return results.stream().map(this::convertToMovie).collect(Collectors.toList());
    }

    private Movie convertToMovie(Map<String, Object> movieData) {
        String id = String.valueOf(movieData.get("id"));
        String title = (String) movieData.get("title");
        String posterPath = "https://image.tmdb.org/t/p/w500" + movieData.get("poster_path");
        String description = (String) movieData.get("overview"); // Assuming 'overview' is the field for description
        String releaseDate = (String) movieData.get("release_date");
        double rating = (Double) movieData.get("vote_average"); // Assuming 'vote_average' is the field for rating

        Movie movie = new Movie(title, posterPath, id);
        movie.setDescription(description);
        movie.setYear(releaseDate);
        movie.setRating(rating);
        return movie;
    }

}
