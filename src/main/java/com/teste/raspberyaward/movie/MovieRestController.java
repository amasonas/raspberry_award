package com.teste.raspberyaward.movie;

import com.teste.raspberyaward.movie.exception.MovieIdAlreadyExistsException;
import com.teste.raspberyaward.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("movies")
public class MovieRestController {

    @Autowired
    MovieService movieService;

    @GetMapping
    public List<Movie> findAll() {
        return movieService.findAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Movie create(@RequestBody MovieDTO movieDTO) throws MovieIdAlreadyExistsException {
        return movieService.save(movieDTO);
    }

    @DeleteMapping("{movie}")
    public MovieDTO delete(@PathVariable("movie") Movie movie) throws Exception {
        return movieService.delete(movie);
    }

}
