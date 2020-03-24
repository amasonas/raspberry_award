package com.teste.raspberyaward.movie.service;

import com.teste.raspberyaward.movie.Movie;
import com.teste.raspberyaward.movie.MovieDTO;
import com.teste.raspberyaward.movie.MovieFactory;
import com.teste.raspberyaward.movie.MovieRepository;
import com.teste.raspberyaward.movie.exception.MovieIdAlreadyExistsException;
import com.teste.raspberyaward.movie.exception.MovieNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MovieServiceImpl implements MovieService {

    @Autowired
    MovieRepository repository;

    @Autowired
    MovieFactory movieFactory;

    public Movie save(Movie movie) {
        return repository.save(movie);
    }

    @Override
    public Movie save(MovieDTO movieDTO) throws MovieIdAlreadyExistsException {
        Movie movie = repository.findById(movieDTO.getId()).orElse(null);

        if (movie != null) {
            throw new MovieIdAlreadyExistsException();
        }

        movie = movieFactory.create(movieDTO);

        return save(movie);
    }

    public List<Movie> saveAll(List<Movie> movies) {
        return repository.saveAll(movies);
    }

    @Override
    public List<Movie> findAll() {
        return repository.findByWinner(true);
    }

    @Override
    public MovieDTO delete(Movie movie) throws MovieNotFoundException {
        if (movie == null) {
            throw new MovieNotFoundException();
        }

        MovieDTO response = movieFactory.create(movie);

        repository.delete(movie);

        return response;
    }
}
