package com.playground.bodyoft.services.exceptions;

public class EntityNotFoundException extends RuntimeException {
    private static final long serialVersionID = 1L;

    public EntityNotFoundException(String msg) {
        super(msg);
    }
}
