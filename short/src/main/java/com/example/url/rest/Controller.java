package com.example.url.rest;

import com.example.url.enums.Status;
import com.example.url.dto.request.UrlRequest;
import com.example.url.dto.response.UrlResponse;
import com.example.url.service.UrlService;
import jakarta.annotation.Nonnull;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/shorten")
public class Controller {
    public UrlService urlService;
    public Controller(UrlService urlService){
        this.urlService = urlService;
    }

    @PostMapping
    public UrlResponse createUrl(@RequestBody @Nonnull UrlRequest urlRequest){
        return urlService.save(urlRequest);
    }
    @GetMapping("/{status}/{shortUrl}")
    public UrlResponse getUrl(@PathVariable String status, @PathVariable String shortUrl){
        return urlService.getUrl(Status.fromString(status), shortUrl);
    }

}
