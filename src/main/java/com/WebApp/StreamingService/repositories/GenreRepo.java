package com.WebApp.StreamingService.repositories;

import com.WebApp.StreamingService.entities.Genre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GenreRepo extends JpaRepository<Genre,Long> {
}
