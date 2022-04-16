package com.example.movie.controller;

import com.example.movie.dto.MoviesDto;
import com.example.movie.models.MovieOverview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.example.movie.models.Movie;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/movies")
public class MovieController {

    @Value("${api.key}")
    private String apiKey;

    @Autowired
    private RestTemplate restTemplate;

    // list of movies
    @GetMapping
    public List<Movie> movies() {

        List<Movie> movieList = new ArrayList<>();
        MoviesDto moviesDto = restTemplate.getForObject("https://api.themoviedb.org/3/discover/movie?api_key=" + apiKey, MoviesDto.class);
        moviesDto.getResults().forEach(
                (movie) -> movieList.add(new Movie(movie.getId(), movie.getTitle(), movie.getOverview()))
        );
        return movieList;
    }

    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable("movieId") String movieId) {
        MovieOverview movieOverview = restTemplate.getForObject("https://api.themoviedb.org/3/movie/" + movieId + "?api_key=" + apiKey, MovieOverview.class);
        return new Movie(movieId, movieOverview.getTitle(), movieOverview.getOverview());
    }


}
