package com.example.url.strategy;

import com.example.url.dto.response.UrlResponse;
import com.example.url.entities.Url;

public class DefaultStrategy implements UrlResponseStrategy{
    @Override
    public UrlResponse toResponse(Url url) {
        return new UrlResponse(url.getId(), url.getOriginalUrl(), url.getShortenedUrl(),null);
    }
}
