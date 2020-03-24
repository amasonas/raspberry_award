package com.teste.raspberyaward.movie.service;

import com.teste.raspberyaward.movie.Movie;
import com.teste.raspberyaward.movie.MovieDTO;
import com.teste.raspberyaward.movie.exception.MovieIdAlreadyExistsException;
import com.teste.raspberyaward.movie.exception.MovieNotFoundException;

import java.util.List;

public interface MovieService {
    Movie save(Movie movie);

    Movie save(MovieDTO movieDTO) throws MovieIdAlreadyExistsException;

    List<Movie> saveAll(List<Movie> movies);

    List<Movie> findAll();

    MovieDTO delete(Movie movie) throws MovieNotFoundException;
}
