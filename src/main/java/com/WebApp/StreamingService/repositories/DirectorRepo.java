package com.WebApp.StreamingService.repositories;

import com.WebApp.StreamingService.entities.Director;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DirectorRepo extends JpaRepository<Director,Long> {
}
