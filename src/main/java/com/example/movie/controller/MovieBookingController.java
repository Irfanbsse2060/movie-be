package com.example.movie.controller;


import com.example.movie.models.MovieBooking;
import com.example.movie.service.MovieBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(value = "/api/v1/movies")
public class MovieBookingController {

    private final MovieBookingService movieBookingService;

    @Autowired
    public MovieBookingController(MovieBookingService movieBookingService) {
        this.movieBookingService = movieBookingService;
    }

    @GetMapping(value = "/booking")
    public List<MovieBooking> getMoviesBooking(@RequestParam(required = false) String query) {
        return movieBookingService.getAllMovieBooking(query);
    }

    @GetMapping(value = "/{movieId}/booking")
    public List<MovieBooking> getMovieBookingsByMovieId(@PathVariable("movieId") String movieId) {
        return movieBookingService.getBookingsOfAMovie(movieId);
    }

    @PostMapping(value = "/{movieId}/booking")
    public MovieBooking createNewMovieBooking(@RequestBody MovieBooking movieBooking) {
        return movieBookingService.insertMovieBooking(movieBooking);
    }

    @PutMapping(value = "/{movieId}/booking")
    public MovieBooking updateMovieBooking(@RequestBody MovieBooking movieBooking) {
        return movieBookingService.updateMovieBooking(movieBooking);
    }

    @DeleteMapping(path = "/booking/{bookingId}")
    public void deleteMovieBooking(@PathVariable("bookingId") Integer bookingId) {
        movieBookingService.deleteMovieBooking(bookingId);
    }

}
