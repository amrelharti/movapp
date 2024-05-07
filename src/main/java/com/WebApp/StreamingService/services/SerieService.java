package com.WebApp.StreamingService.services;

import com.WebApp.StreamingService.entities.Serie;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SerieService {
    Serie saveSerie(Serie serie);
    Serie updateSerie(Serie serie);
    void deleteSerieById(Long id);
    void deleteAllSeries();
    Serie getSerieById(Long id);
    List<Serie> getAllSeries();
}
