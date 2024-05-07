package com.WebApp.StreamingService.services;

import com.WebApp.StreamingService.entities.Serie;
import com.WebApp.StreamingService.repositories.SerieRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SerieServiceImpl implements SerieService{
    private SerieRepo serieRepo;
    @Override
    public Serie saveSerie(Serie serie) {
        return serieRepo.save(serie);
    }

    @Override
    public Serie updateSerie(Serie serie) {
        return serieRepo.save(serie);
    }

    @Override
    public void deleteSerieById(Long id) {
        serieRepo.deleteById(id);
    }

    @Override
    public void deleteAllSeries() {
        serieRepo.deleteAll();
    }

    @Override
    public Serie getSerieById(Long id) {
        return serieRepo.findById(id).get();
    }

    @Override
    public List<Serie> getAllSeries() {
        return serieRepo.findAll();
    }
}
