package com.WebApp.StreamingService.services;

import com.WebApp.StreamingService.entities.Media;
import com.WebApp.StreamingService.repositories.MediaRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediaServiceImpl implements MediaService{
    private MediaRepo mediaRepo;
    @Override
    public Media saveMedia(Media media) {
        return mediaRepo.save(media);
    }

    @Override
    public Media updateMedia(Media media) {
        return mediaRepo.save(media);
    }

    @Override
    public void deleteMediaById(Long id) {
        mediaRepo.deleteById(id);
    }

    @Override
    public void deleteAllMedias() {
        mediaRepo.deleteAll();
    }

    @Override
    public Media getMediaById(Long id) {
        return mediaRepo.findById(id).get();
    }

    @Override
    public List<Media> getAllMedias() {
        return mediaRepo.findAll();
    }
}
