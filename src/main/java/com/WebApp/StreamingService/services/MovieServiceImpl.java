package com.WebApp.StreamingService.services;

import com.WebApp.StreamingService.entities.Movie;
import com.WebApp.StreamingService.repositories.MovieRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class MovieServiceImpl implements MovieService{
    private MovieRepo movieRepo;
    @Override
    public Movie saveMovie(Movie movie) {
        return movieRepo.save(movie);
    }

    @Override
    public Movie updateMovie(Movie movie) {
        return movieRepo.save(movie);
    }

    @Override
    public void deleteMovieById(Long id) {
        movieRepo.deleteById(id);
    }

    @Override
    public void deleteAllMovies() {
        movieRepo.deleteAll();
    }

    @Override
    public Movie getMovieById(Long id) {
        return movieRepo.findById(id).get();
    }

    @Override
    public List<Movie> getAllMovies() {
        return movieRepo.findAll();
    }
}
