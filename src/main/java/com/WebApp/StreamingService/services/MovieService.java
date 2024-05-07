package com.WebApp.StreamingService.services;

import com.WebApp.StreamingService.entities.Movie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MovieService {
    Movie saveMovie(Movie movie);
    Movie updateMovie(Movie movie);
    void deleteMovieById(Long id);
    void deleteAllMovies();
    Movie getMovieById(Long id);
    List<Movie> getAllMovies();
}
