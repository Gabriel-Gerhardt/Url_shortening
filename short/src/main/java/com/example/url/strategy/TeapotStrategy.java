package com.example.url.strategy;

import com.example.url.dto.response.UrlResponse;
import com.example.url.entities.Url;

public class TeapotStrategy implements UrlResponseStrategy{

    @Override
    public UrlResponse toResponse(Url url){
        return new UrlResponse(null,"TeapotEasterEgg","TeapotEasterEgg",null);
    }
}
