package com.example.movie.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovieOverview {

    private String id;
    private String title;
    private String overview;
    private String poster_path;
    private String original_title;
    private String release_date;

}

