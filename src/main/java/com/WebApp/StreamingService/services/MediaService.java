package com.WebApp.StreamingService.services;

import com.WebApp.StreamingService.entities.Media;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface MediaService {
    Media saveMedia(Media media);
    Media updateMedia(Media media);
    void deleteMediaById(Long id);
    void deleteAllMedias();
    Media getMediaById(Long id);
    List<Media> getAllMedias();
}
