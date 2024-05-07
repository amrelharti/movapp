package com.WebApp.StreamingService.services;

import com.WebApp.StreamingService.entities.Director;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DirectorService {
    Director saveDirector(Director director);
    Director updateDirector(Director director);
    void deleteDirectorById(Long id);
    void deleteAllDirectors();
    Director getDirectorById(Long id);
    List<Director> getAllDirectors();

}
