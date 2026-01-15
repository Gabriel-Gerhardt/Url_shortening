package com.example.url.enums;

public enum Status {
    STATUS,
    TEAPOT,
    DEFAULT;

    public static Status fromString(String value) {
        if (value == null) return DEFAULT;
        return Status.valueOf(value.toUpperCase());
    }
}
