package com.example.url.strategy;

import com.example.url.dto.response.UrlResponse;
import com.example.url.entities.Url;

public class StatusResponse implements UrlResponseStrategy {

    @Override
    public UrlResponse toResponse(Url url){
        return new UrlResponse(url.getId(), url.getOriginalUrl(), url.getShortenedUrl(), url.getTimesAccessed());
    }
}
