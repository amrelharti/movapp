

package com.WebApp.StreamingService.services;

import com.WebApp.StreamingService.config.ApiConfiguration;
import com.WebApp.StreamingService.entities.Movie;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class ImdbService {

    @Value("${moviedb.api.key}")
    private String apiKey;

    private final RestTemplate restTemplate = new RestTemplate();

    private static final String API_URL = ApiConfiguration.IMDB_API_URL + "/movie/id/";

    public Movie findMovieById(String movieId) {
        try {
            HttpHeaders headers = new HttpHeaders();
            headers.set("X-RapidAPI-Key", ApiConfiguration.IMDB_API_KEY);
            headers.set("X-RapidAPI-Host", "moviesminidatabase.p.rapidapi.com");
            HttpEntity<String> entity = new HttpEntity<>(headers);

            String url = API_URL + movieId ; // Ensure URL is correct
            ResponseEntity<String> response = restTemplate.exchange(url, HttpMethod.GET, entity, String.class);

            System.out.println("Response status: " + response.getStatusCode()); // Log the response status

            if (response.getStatusCode() == HttpStatus.OK && response.getBody() != null) {
                ObjectMapper objectMapper = new ObjectMapper();
                objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);

                JsonNode rootNode = objectMapper.readTree(response.getBody());
                JsonNode resultsNode = rootNode.path("results");

                Movie movie = objectMapper.treeToValue(resultsNode, Movie.class);
                movie.setPosterPath( resultsNode.path("image_url").asText());
                movie.setImdbId(movieId);

                System.out.println("Movie fetched: " + movie.getTitle() + ", ID: " + movie.getImdbId()); // Log movie details

                return movie;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }




    public List<Movie> fetchAllMovies() {
        String[] categories = { "popular", "now_playing", "upcoming", "top_rated" };
        System.out.println("Fetching movies for categories: " + Arrays.toString(categories));  // Log categories being fetched
        return List.of(categories).stream()
                .flatMap(category -> {
                    List<Movie> movies = fetchMoviesByCategory(category);
                    System.out.println("Fetched " + movies.size() + " movies for category: " + category);  // Log the number of movies fetched per category
                    return movies.stream();
                })
                .collect(Collectors.toList());
    }

    /*private List<Movie> fetchMoviesByCategory(String category) {
        String url = String.format("https://api.themoviedb.org/3/movie/%s?api_key=%s", category, apiKey);
        try {
            ResponseEntity<Map> responseEntity = restTemplate.getForEntity(url, Map.class);

            if (responseEntity.getStatusCode() == HttpStatus.OK && responseEntity.hasBody()) {
                Map<String, Object> response = responseEntity.getBody();
                List<Map<String, Object>> results = (List<Map<String, Object>>) response.get("results");
                List<Movie> movies = results.stream()
                        .map(result -> new Movie(
                                (String) result.get("title"),
                                "https://image.tmdb.org/t/p/w500" + result.get("poster_path"),
                                (String) result.get("imdbId")
                        ))
                        .collect(Collectors.toList());
                System.out.println("Successfully retrieved " + movies.size() + " movies from category: " + category);  // Log success and count
                return movies;
            } else {
                System.out.println("Failed to fetch movies for category: " + category + " with status: " + responseEntity.getStatusCode());  // Log failure
            }
        } catch (Exception e) {
            System.err.println("Error fetching movies from category " + category + ": " + e.getMessage());
            e.printStackTrace();
        }
        return Collections.emptyList();  // Return empty list on error or no data
    }*/
    private List<Movie> fetchMoviesByCategory(String category) {
        String url = String.format("https://api.themoviedb.org/3/movie/%s?api_key=%s", category, apiKey);
        try {
            ResponseEntity<Map> responseEntity = restTemplate.getForEntity(url, Map.class);

            if (responseEntity.getStatusCode() == HttpStatus.OK && responseEntity.hasBody()) {
                Map<String, Object> response = responseEntity.getBody();
                List<Map<String, Object>> results = (List<Map<String, Object>>) response.get("results");
                List<Movie> movies = new ArrayList<>();

                for (Map<String, Object> result : results) {
                    String movieId = String.valueOf(result.get("id"));
                    Movie movie = fetchMovieDetails(movieId);
                    if (movie != null) {
                        movies.add(movie);
                    }
                }
                System.out.println("Successfully retrieved " + movies.size() + " movies from category: " + category);
                return movies;
            } else {
                System.out.println("Failed to fetch movies for category: " + category + " with status: " + responseEntity.getStatusCode());
            }
        } catch (Exception e) {
            System.err.println("Error fetching movies from category " + category + ": " + e.getMessage());
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    private Movie fetchMovieDetails(String movieId) {
        String detailsUrl = String.format("https://api.themoviedb.org/3/movie/%s?api_key=%s&append_to_response=external_ids", movieId, apiKey);
        try {
            ResponseEntity<Map> responseEntity = restTemplate.getForEntity(detailsUrl, Map.class);
            if (responseEntity.getStatusCode() == HttpStatus.OK && responseEntity.hasBody()) {
                Map<String, Object> movieData = responseEntity.getBody();
                String title = (String) movieData.get("title");
                String posterPath = "https://image.tmdb.org/t/p/w500" + movieData.get("poster_path");
                Map<String, String> externalIds = (Map<String, String>) movieData.get("external_ids");
                String imdbId = externalIds.get("imdb_id"); // Correct key for IMDb ID

                return new Movie(title, posterPath, imdbId);
            }
        } catch (Exception e) {
            System.err.println("Error fetching movie details for ID " + movieId + ": " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    public List<Movie> searchMovies(String query) {
        String url = UriComponentsBuilder.fromHttpUrl("https://api.themoviedb.org/3/search/movie")
                .queryParam("api_key", apiKey)
                .queryParam("query", query)
                .toUriString();

        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(headers);
        ResponseEntity<Map> response = restTemplate.exchange(url, HttpMethod.GET, entity, Map.class);

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
        return new Movie(
                (String) movieData.get("title"),
                "https://image.tmdb.org/t/p/w500" + movieData.get("poster_path"),
                (String) movieData.get("release_date")

        );
    }
}

