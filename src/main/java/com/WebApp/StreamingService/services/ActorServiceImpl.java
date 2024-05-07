package com.WebApp.StreamingService.services;

import com.WebApp.StreamingService.entities.Actor;
import com.WebApp.StreamingService.repositories.ActorRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ActorServiceImpl implements ActorService {
    private ActorRepo actorRepo;
    @Override
    public Actor saveActor(Actor actor) {
        return actorRepo.save(actor);
    }

    @Override
    public Actor updateActor(Actor actor) {
        return actorRepo.save(actor);
    }

    @Override
    public void deleteActorById(Long id) {
        actorRepo.deleteById(id);
    }

    @Override
    public void deleteAllActors() {
        actorRepo.deleteAll();
    }

    @Override
    public Actor getActorById(Long id) {
        return actorRepo.findById(id).get();
    }

    @Override
    public List<Actor> getAllActors() {
        return actorRepo.findAll();
    }
}
