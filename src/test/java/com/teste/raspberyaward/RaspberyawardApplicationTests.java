package com.teste.raspberyaward;

import com.teste.raspberyaward.config.DataLoader;
import com.teste.raspberyaward.config.exception.NonStandardDataExeption;
import com.teste.raspberyaward.movie.Movie;
import com.teste.raspberyaward.movie.MovieDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class RaspberyawardApplicationTests {
    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private DataLoader dataLoader;

    @Test
    public void mustCreateMovie() {
        MovieDTO movieDTO = new MovieDTO();
        String[] producers = {"Kwak Sin-ae", "Moon Yang-kwon", "Jang Young-hwan"};
        String[] studios = {"Barunson E&A Corp"};

        movieDTO.setTitle("Gisaengchung");
        movieDTO.setProducers(Arrays.asList(producers));
        movieDTO.setStudios(Arrays.asList(studios));

        ResponseEntity<Movie> responseEntity = restTemplate.postForEntity("/movies/", movieDTO, Movie.class);

        Assertions.assertThat(responseEntity.getStatusCode()).isEqualByComparingTo(HttpStatus.CREATED);
    }

    @Test
    public void checkHeaderException() {
        String header = "year;title;studios;winner";

        try {
            dataLoader.checkHeader(header);
        } catch (Exception e) {
            Assertions.assertThat(e instanceof NonStandardDataExeption);
        }
    }
}
