package com.teste.raspberyaward.config;

import com.teste.raspberyaward.config.exception.NonStandardDataExeption;
import com.teste.raspberyaward.movie.Movie;
import com.teste.raspberyaward.movie.MovieFactory;
import com.teste.raspberyaward.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements ApplicationRunner {

    @Autowired
    ExcelReader excelReader;

    @Autowired
    MovieFactory movieFactory;

    @Autowired
    MovieService movieService;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        List<String> movieList = excelReader.getMovieListFromResources();

        validate(movieList);

        if (!movieList.isEmpty()) {
            List<Movie> movies = movieFactory.create(movieList);

            movieService.saveAll(movies);
        }
    }

    public void validate(List<String> movieList) throws Exception {
        String header = movieList.get(0);

        checkHeader(header);
    }

    public void checkHeader(String header) throws NonStandardDataExeption {
        String[] headerArray = header.split(";");

        if (headerArray.length != 5 ||
                !headerArray[0].equalsIgnoreCase("year") ||
                !headerArray[1].equalsIgnoreCase("title") ||
                !headerArray[2].equalsIgnoreCase("studios") ||
                !headerArray[3].equalsIgnoreCase("producers") ||
                !headerArray[4].equalsIgnoreCase("winner")

        ) {
            throw new NonStandardDataExeption();
        }
    }
}
