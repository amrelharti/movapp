package com.WebApp.StreamingService.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor


public class Movie extends Media{
    private int duration;
    private String title;
    private String posterPath;
    private String imdbId;

    public Movie(String title,String posterPath,String imdbId) {
        this.posterPath = posterPath;
        this.title = title;
        this.imdbId=imdbId;
    }

}
