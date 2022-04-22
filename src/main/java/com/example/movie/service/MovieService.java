package com.example.movie.service;

import com.example.movie.dto.MovieReviewDto;
import com.example.movie.dto.MoviesDto;
import com.example.movie.models.Movie;
import com.example.movie.models.MovieOverview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class MovieService {

    @Value("${api.key}")
    private String apiKey;
    private final String API_BASE_URL = "https://api.themoviedb.org/3";

    @Autowired
    private final RestTemplate restTemplate;

    @Autowired
    public MovieService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public Movie getMovieInfo(String movieId) {
        String api=  String.format("%s/movie/%s?api_key=%s",API_BASE_URL, movieId,  apiKey);
        return restTemplate.getForObject(api, Movie.class);
    }

    public MovieReviewDto getMovieReviews(String movieId, Integer page) {
        String api=  String.format("%s/movie/%s/reviews?api_key=%s&page=%s",API_BASE_URL, movieId,  apiKey,page);
        return restTemplate.getForObject(api, MovieReviewDto.class);
    }

    public List<MovieOverview> searchMovies(String query) {
        String api=  String.format("%s/search/movie?api_key=%s&query=%s",API_BASE_URL,  apiKey, query);
        MoviesDto moviesDto = restTemplate.getForObject(api, MoviesDto.class);
        return moviesDto.getResults();
    }

    public List<MovieOverview> movies() {
        String api=  String.format("%s/discover/movie?sort_by=popularity.desc&api_key=%s",API_BASE_URL,  apiKey);
        MoviesDto moviesDto = restTemplate.getForObject(api, MoviesDto.class);
        return moviesDto.getResults();
    }
}