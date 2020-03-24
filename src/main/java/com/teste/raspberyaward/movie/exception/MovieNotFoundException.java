package com.teste.raspberyaward.movie.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class MovieNotFoundException extends Exception {

    public MovieNotFoundException() {
        super("The referenced movie was not found");
    }
}
