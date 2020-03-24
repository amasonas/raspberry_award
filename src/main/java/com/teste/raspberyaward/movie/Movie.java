package com.teste.raspberyaward.movie;

import com.teste.raspberyaward.producer.Producer;
import com.teste.raspberyaward.studio.Studio;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@Entity
@Table
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private int year;

    private Boolean winner = false;

    private String title;

    @ManyToMany
    @JoinTable(
            name = "movie_studios",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "studio_id"))
    private List<Studio> studios;

    @ManyToMany
    @JoinTable(
            name = "movie_producers",
            joinColumns = @JoinColumn(name = "movie_id"),
            inverseJoinColumns = @JoinColumn(name = "producer_id"))
    private List<Producer> producers;
}
