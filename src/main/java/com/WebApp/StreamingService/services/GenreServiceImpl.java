package com.WebApp.StreamingService.services;

import com.WebApp.StreamingService.entities.Genre;
import com.WebApp.StreamingService.repositories.GenreRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreServiceImpl implements GenreService{
    private GenreRepo genreRepo;
    @Override
    public Genre saveGenre(Genre genre) {
        return genreRepo.save(genre);
    }

    @Override
    public Genre updateGenre(Genre genre) {
        return genreRepo.save(genre);
    }

    @Override
    public void deleteGenreById(Long id) {
        genreRepo.deleteById(id);
    }

    @Override
    public void deleteAllGenres() {
        genreRepo.deleteAll();
    }

    @Override
    public Genre getGenreById(Long id) {
        return genreRepo.findById(id).get();
    }

    @Override
    public List<Genre> getAllGenres() {
        return genreRepo.findAll();
    }
}
