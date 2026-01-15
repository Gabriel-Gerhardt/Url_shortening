package com.example.url.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UrlRequest (
    @JsonProperty("url")
    String originalUrl
    ) {

}
