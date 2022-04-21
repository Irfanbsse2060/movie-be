package com.example.movie.controller;

import com.example.movie.dto.MovieReviewDto;
import com.example.movie.models.MovieOverview;
import com.example.movie.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.movie.models.Movie;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/movies")
public class MovieController {

    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping()
    public List<MovieOverview> movies() {
        return movieService.movies();
    }

    @GetMapping("/search")
    public List<MovieOverview> searchMovies(@RequestParam(required = true) String query) {
        return movieService.searchMovies(query);
    }

    @GetMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
        return movieService.getMovieInfo(movieId);
    }

    @GetMapping("/{movieId}/reviews")
    public MovieReviewDto getMovieReviews(@PathVariable("movieId") String movieId, @RequestParam(defaultValue = "1") Integer page) {
        return movieService.getMovieReviews(movieId, page);
    }
}
