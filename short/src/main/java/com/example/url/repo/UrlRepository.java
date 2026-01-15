package com.example.url.repo;

import com.example.url.entities.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface UrlRepository extends JpaRepository<Url, UUID> {
    Url findByShortenedUrl(String shortUrl);

    @Modifying
    @Query("UPDATE Url u SET u.timesAccessed = COALESCE(u.timesAccessed, 0)" +
            " + 1 WHERE u.shortenedUrl = :shortUrl")
    void incrementTimesAccessed(@Param("shortUrl") String shortUrl);
}
