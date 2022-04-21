package com.example.movie.models;

import lombok.Data;

@Data
public class MovieOverview {

    private String id;
    private String title;
    private String overview;
    private String poster_path;
    private String original_title;
    private String release_date;
    private Float vote_average;

}

