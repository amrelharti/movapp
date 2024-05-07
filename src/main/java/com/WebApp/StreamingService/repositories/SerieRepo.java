package com.WebApp.StreamingService.repositories;

import com.WebApp.StreamingService.entities.Serie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SerieRepo extends JpaRepository<Serie,Long> {
}
