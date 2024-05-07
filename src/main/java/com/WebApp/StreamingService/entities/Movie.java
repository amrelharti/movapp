package com.WebApp.StreamingService.entities;

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

    public Movie(String id, String title, String posterPath, String overview) {
    }

    public Movie(String title, String posterPath) {
    }
}
