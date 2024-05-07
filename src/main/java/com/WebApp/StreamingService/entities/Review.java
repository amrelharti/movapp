package com.WebApp.StreamingService.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String reviewText;
    private long id_user;
    @ManyToMany
    @JoinTable(name = "Media_Review")
    private List<Media> medias=new ArrayList<>();
}
