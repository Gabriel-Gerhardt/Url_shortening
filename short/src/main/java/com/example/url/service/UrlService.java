package com.example.url.service;

import com.example.url.enums.Status;
import com.example.url.dto.request.UrlRequest;
import com.example.url.dto.response.UrlResponse;
import com.example.url.entities.Url;
import com.example.url.exception.InvalidUrlRequestException;
import com.example.url.exception.ShortUrlDoesNotExist;
import com.example.url.repo.UrlRepository;
import com.example.url.strategy.DefaultStrategy;
import com.example.url.strategy.StatusResponse;
import com.example.url.strategy.TeapotStrategy;
import com.example.url.strategy.UrlResponseStrategy;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class UrlService {
    private final UrlRepository urlRepository;


    public UrlService(UrlRepository urlRepository) {
        this.urlRepository = urlRepository;
    }

    public UrlResponse save(UrlRequest urlRequest){
        validateUrlRequestIsValid(urlRequest);
        Url url = new Url
                (urlRequest.originalUrl(),
                generateShortenedUrl(),
                0);

        urlRepository.save(url);
        return new UrlResponse(url.getId(),
                url.getOriginalUrl(),
                url.getShortenedUrl(),null);

    }
    @Transactional
    public UrlResponse getUrl(Status status, String shortUrl){
        Url url = urlRepository.findByShortenedUrl(shortUrl);

        validateShortUrlExists(url);

        urlRepository.incrementTimesAccessed(shortUrl);

        Url incrementedUrl = urlRepository.findByShortenedUrl(shortUrl);

        return chooseResponse(status,incrementedUrl);
    }


    public void validateShortUrlExists(Url url){
        if (url == null){
            throw new ShortUrlDoesNotExist(HttpStatus.NOT_FOUND,"The shortUrl does not exist in the database");
        }
    }
    public void validateUrlRequestIsValid(UrlRequest urlRequest){
        if(urlRequest.originalUrl() == null){
            throw new InvalidUrlRequestException(HttpStatus.BAD_REQUEST,"Invalid request for shortener url");
        }
    }

    public boolean shortenedStringExistsInDatabase(String shortenedUrl){
        return urlRepository.findAll()
                .stream()
                .anyMatch(url -> url.getShortenedUrl().equals(shortenedUrl));

    }

    public UrlResponse chooseResponse(Status status, Url url){
        UrlResponseStrategy strategy = switch (status){
            case STATUS -> new StatusResponse();
            case TEAPOT -> new TeapotStrategy();
            default -> new DefaultStrategy();
        };
        return strategy.toResponse(url);
    }

    public String generateShortenedUrl(){
        int length = 6;
        String chars = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(chars.length());
            sb.append(chars.charAt(index));
        }

        String randomString = sb.toString();
        if(shortenedStringExistsInDatabase(randomString)){
            return generateShortenedUrl();
        }
        return randomString;
    }
}
