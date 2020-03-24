package com.teste.raspberyaward.movie;

import com.teste.raspberyaward.producer.Producer;
import com.teste.raspberyaward.producer.service.ProducerService;
import com.teste.raspberyaward.studio.Studio;
import com.teste.raspberyaward.studio.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class MovieFactory {

    @Autowired
    StudioService studioService;

    @Autowired
    ProducerService producerService;

    public List<Movie> create(List<String> moviesFromCsv) {

        List<Movie> movieList = new ArrayList<>();

        moviesFromCsv.forEach(movie -> {
            if (movie.startsWith("year")) {
                return;
            }

            movieList.add(create(movie));
        });

        return movieList;
    }

    public Movie create(String movieCsvLine) {
        String[] movieArray = movieCsvLine.split(";");

        Movie movie = new Movie();

        movie.setYear(Integer.valueOf(movieArray[0]));
        movie.setTitle(movieArray[1]);
        movie.setStudios(getStudios(Arrays.asList(movieArray[2].split(","))));
        movie.setProducers(getProducers(Arrays.asList(movieArray[3].split(","))));

        if (movieArray.length == 5) {
            movie.setWinner(movieArray[4].equals("yes"));
        }

        return movie;
    }

    public Movie create(MovieDTO movieDTO) {
        Movie movie = new Movie();

        movie.setId(movie.getId());
        movie.setYear(movieDTO.getYear());
        movie.setTitle(movieDTO.getTitle());
        movie.setWinner(movieDTO.getWinner());
        movie.setStudios(getStudios(movieDTO.getStudios()));
        movie.setProducers(getProducers(movieDTO.getProducers()));

        return movie;
    }

    public MovieDTO create(Movie movie) {
        MovieDTO request = new MovieDTO();

        request.setId(movie.getId());
        request.setTitle(movie.getTitle());
        request.setStudios(getStudiosName(movie.getStudios()));
        request.setProducers(getProducersName(movie.getProducers()));
        request.setWinner(movie.getWinner());
        request.setYear(movie.getYear());

        return request;
    }

    public List<String> getStudiosName(List<Studio> studioList) {
        List<String> names = new ArrayList<>();

        studioList.forEach(studio -> {
            names.add(studio.getName());
        });

        return names;
    }

    public List<String> getProducersName(List<Producer> producerList) {
        List<String> names = new ArrayList<>();

        producerList.forEach(producer -> {
            names.add(producer.getName());
        });

        return names;
    }

    public List<Studio> getStudios(List<String> studios) {
        List<Studio> studiosList = new ArrayList<>();

        studios.forEach(studioName -> {
            studiosList.add(studioService.findByNameOrCreate(studioName.trim()));
        });

        return studiosList;
    }

    public List<Producer> getProducers(List<String> studios) {
        List<Producer> producerList = new ArrayList<>();

        studios.forEach(studioName -> {
            producerList.add(producerService.findByNameOrCreate(studioName.trim()));
        });

        return producerList;
    }
}
