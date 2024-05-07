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

public class Serie extends Media{
    private int season;
    private int episode;
    private int current_ep;
}
