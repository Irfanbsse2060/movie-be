package com.example.movie.controller;

import com.example.movie.dto.MovieReviewDto;
import com.example.movie.dto.MoviesDto;
import com.example.movie.models.MovieOverview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import com.example.movie.models.Movie;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1")
public class MovieController {

    @Value("${api.key}")
    private String apiKey;


    @Autowired
    private RestTemplate restTemplate;

    // list of movies
    @GetMapping("/movies")
    public List<MovieOverview> movies() {
        MoviesDto moviesDto = restTemplate.getForObject("https://api.themoviedb.org/3/discover/movie?api_key=" + apiKey, MoviesDto.class);
        return moviesDto.getResults();
    }

    // list of movies
    @GetMapping("/search/movies")
    public List<MovieOverview> searchMovies(@RequestParam(required = true) String query ) {
        MoviesDto moviesDto = restTemplate.getForObject("https://api.themoviedb.org/3/search/movie?api_key=" + apiKey+"&query="+query, MoviesDto.class);
        return moviesDto.getResults();
    }

    @GetMapping("/movies/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
        Movie movie = restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey, Movie.class);
        return movie;
    }

    @GetMapping("/movies/{movieId}/reviews")
    public MovieReviewDto getMovieReviews(@PathVariable("movieId") String movieId, @RequestParam(defaultValue="1") Integer page ) {
        MovieReviewDto movieReviewDto = restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + movieId +"/reviews" + "?api_key=" + apiKey+"&page="+page,
                MovieReviewDto.class);
        return movieReviewDto;
    }


}
