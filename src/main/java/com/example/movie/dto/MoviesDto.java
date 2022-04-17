package com.example.movie.dto;

import com.example.movie.models.MovieOverview;
import lombok.Data;

import java.util.List;

@Data
public class MoviesDto {
    private String page;
    private List<MovieOverview> results;
}
