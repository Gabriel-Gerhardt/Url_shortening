package com.example.url.strategy;

import com.example.url.dto.response.UrlResponse;
import com.example.url.entities.Url;

@FunctionalInterface
public interface UrlResponseStrategy {
    UrlResponse toResponse(Url url);
}