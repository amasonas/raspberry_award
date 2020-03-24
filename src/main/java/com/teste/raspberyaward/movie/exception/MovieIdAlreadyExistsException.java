package com.teste.raspberyaward.movie.exception;

public class MovieIdAlreadyExistsException extends Exception {
    public MovieIdAlreadyExistsException() {
        super("The given id already belongs to a record");
    }
}
