package com.WebApp.StreamingService.services;

import com.WebApp.StreamingService.entities.Genre;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface GenreService {
    Genre saveGenre(Genre genre);
    Genre updateGenre(Genre genre);
    void deleteGenreById(Long id);
    void deleteAllGenres();
    Genre getGenreById(Long id);
    List<Genre> getAllGenres();
}
