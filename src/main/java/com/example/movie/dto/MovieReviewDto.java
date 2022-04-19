package com.example.movie.dto;

import com.example.movie.models.MovieReview;
import lombok.Data;

import java.util.List;

@Data
public class MovieReviewDto {
    private String id;
    private Integer page;
    private Integer total_pages;
    private Integer total_results;
    private List<MovieReview> results;
}
