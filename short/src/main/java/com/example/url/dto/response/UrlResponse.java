package com.example.url.dto.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.UUID;

@JsonInclude(JsonInclude.Include.NON_NULL)
public record UrlResponse(
        @JsonProperty("id")
        UUID id,
        @JsonProperty("url")
        String originalUrl,
        @JsonProperty("shortCode")
        String shortenedUrl,
        @JsonProperty("timesAccessed")
        Integer timesAccessed
) {
}