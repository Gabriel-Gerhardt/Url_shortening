package com.example.url.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "urls")
public class Url {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    UUID id;

    String originalUrl;

    @Column(name = "shortened_url", unique = true)
    String shortenedUrl;

    Integer timesAccessed;


    public Url(String originalUrl, String shortenedUrl, Integer timesAccessed) {
        this.originalUrl = originalUrl;
        this.shortenedUrl = shortenedUrl;
        this.timesAccessed = timesAccessed;
    }
}
