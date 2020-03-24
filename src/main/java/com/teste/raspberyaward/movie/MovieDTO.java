package com.teste.raspberyaward.movie;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class MovieDTO {
    private long id;
    private int year;

    private Boolean winner = false;

    private String title;

    private List<String> producers;
    private List<String> studios;
}
