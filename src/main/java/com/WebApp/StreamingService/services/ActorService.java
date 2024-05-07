package com.WebApp.StreamingService.services;

import com.WebApp.StreamingService.entities.Actor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ActorService {
    Actor saveActor(Actor actor);
    Actor updateActor(Actor actor);
    void deleteActorById(Long id);
    void deleteAllActors();
    Actor getActorById(Long id);
    List<Actor> getAllActors();

}
