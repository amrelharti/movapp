package com.WebApp.StreamingService.services;

import com.WebApp.StreamingService.entities.Director;
import com.WebApp.StreamingService.repositories.DirectorRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DirectorServiceImpl implements DirectorService {
    private DirectorRepo directorRepo;
    @Override
    public Director saveDirector(Director director) {
        return directorRepo.save(director);
    }

    @Override
    public Director updateDirector(Director director) {
        return directorRepo.save(director);
    }

    @Override
    public void deleteDirectorById(Long id) {
        directorRepo.deleteById(id);
    }

    @Override
    public void deleteAllDirectors() {
        directorRepo.deleteAll();
    }

    @Override
    public Director getDirectorById(Long id) {
        return directorRepo.findById(id).get();
    }

    @Override
    public List<Director> getAllDirectors() {
        return directorRepo.findAll();
    }
}
