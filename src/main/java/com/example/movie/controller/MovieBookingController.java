package com.example.movie.controller;


import com.example.movie.models.MovieBooking;
import com.example.movie.service.MovieBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Optional;
//import java.util.UUID;
//import javax.validation.Valid;
//import javax.validation.constraints.NotNull;

@RestController
@RequestMapping(value = "/api/v1")
public class MovieBookingController {

    private final MovieBookingService movieBookingService;

    @Autowired
    public MovieBookingController(MovieBookingService movieBookingService) {
        this.movieBookingService = movieBookingService;
    }

    @GetMapping(value = "/movies/booking")
    public List<MovieBooking> getMoviesBooking() {
        return movieBookingService.getAllMovieBooking();
    }

    @GetMapping(value = "/movies/{movieId}/booking")
    public List<MovieBooking> getMovieBookingsByMovieId(@PathVariable("movieId") String movieId) {
        return movieBookingService.getBookingsOfAMovie(movieId);
    }

    @PostMapping(value="/movies/{movieId}/booking")
    public MovieBooking createNewMovieBooking( @RequestBody MovieBooking movieBooking) {
        return movieBookingService.insertMovieBooking(movieBooking);
    }

    @PutMapping(value="/movies/{movieId}/booking")
    public Optional<MovieBooking> updateMovieBooking(@RequestBody MovieBooking movieBooking) {
        return movieBookingService.updateMovieBooking(movieBooking);
    }

    @DeleteMapping(path = "/movies/booking/{bookingId}")
    public void deleteMovieBooking(@PathVariable("bookingId") Integer bookingId) {
         movieBookingService.deleteMovieBooking(bookingId);
    }


}
