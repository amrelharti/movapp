package com.WebApp.StreamingService.repositories;

import com.WebApp.StreamingService.entities.Media;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MediaRepo extends JpaRepository<Media,Long> {
}
