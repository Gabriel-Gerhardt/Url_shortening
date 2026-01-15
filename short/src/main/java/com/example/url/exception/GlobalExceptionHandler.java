package com.example.url.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(ShortUrlDoesNotExist.class)
    public ResponseEntity<?> handleShortUrlDoesNotExist(ShortUrlDoesNotExist e) {
        return formatResponseStatusException(e);
    }

    @ExceptionHandler(InvalidUrlRequestException.class)
    public ResponseEntity<?> handleInvalidUrlRequestException(InvalidUrlRequestException e) {
        return formatResponseStatusException(e);
    }

    public ResponseEntity<?> formatResponseStatusException(ResponseStatusException e){
        return ResponseEntity
                .status(e.getStatusCode())
                .body(Map.of(
                        "status", e.getStatusCode().value(),
                        "message", e.getReason()
                ));
    }
}
