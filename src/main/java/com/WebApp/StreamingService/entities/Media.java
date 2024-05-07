package com.WebApp.StreamingService.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Inheritance(strategy = InheritanceType.JOINED)


public abstract class Media {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private String title;
    private String description;
    private Date release_date;
    private long id_genre;
    private long id_actor;
    private long id_director;
    private double rating;
    @ManyToMany(mappedBy = "medias",fetch = FetchType.LAZY)
    private List<Genre> genres=new ArrayList<>();
    @ManyToMany(mappedBy = "medias",fetch = FetchType.LAZY)
    private List<Actor> actors=new ArrayList<>();
    @ManyToMany(mappedBy = "medias",fetch = FetchType.LAZY)
    private List<Director> directors=new ArrayList<>();
    @ManyToMany(mappedBy = "medias",fetch = FetchType.LAZY)
    private List<Review> reviews=new ArrayList<>();

}
