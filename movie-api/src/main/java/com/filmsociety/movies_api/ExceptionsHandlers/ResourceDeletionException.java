package com.filmsociety.movies_api.ExceptionsHandlers;

public class ResourceDeletionException extends RuntimeException {
    public ResourceDeletionException(String message) {
        super(message);
    }
}
