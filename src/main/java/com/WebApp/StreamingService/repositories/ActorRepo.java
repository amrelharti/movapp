package com.WebApp.StreamingService.repositories;

import com.WebApp.StreamingService.entities.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActorRepo extends JpaRepository<Actor,Long> {

}
