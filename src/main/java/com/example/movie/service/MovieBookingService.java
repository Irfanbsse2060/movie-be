package com.example.movie.service;
import com.example.movie.models.MovieBooking;
import com.example.movie.models.MovieBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieBookingService {

    private final MovieBookingRepository movieBookingRepository;

    @Autowired
    public MovieBookingService( MovieBookingRepository movieBookingRepository) {
        this.movieBookingRepository = movieBookingRepository;
    }

    public List<MovieBooking> getAllMovieBooking(String movieId) {
        return movieBookingRepository.findAllByMovieId(movieId);
    }

    public MovieBooking insertMovieBooking(MovieBooking movieBooking) {
        return movieBookingRepository.save(movieBooking);
    }

    public void deleteMovieBooking(String movieId, Integer movieBookingId) {
        MovieBooking movieBooking = movieBookingRepository.findByMovieIdAndAndId(movieId, movieBookingId);
        movieBookingRepository.delete(movieBooking);
    }

    public Optional<MovieBooking> updateMovieBooking(MovieBooking movieBooking) {
        Optional<MovieBooking> existingMovieBooking = movieBookingRepository.findById(movieBooking.getId());
        if(existingMovieBooking.isPresent())
        {
            existingMovieBooking.get().setEmail(movieBooking.getEmail());
            existingMovieBooking.get().setFirstName(movieBooking.getFirstName());
            existingMovieBooking.get().setLastName(movieBooking.getLastName());
            existingMovieBooking.get().setNumberOfSeats(movieBooking.getNumberOfSeats());
            movieBookingRepository.save(existingMovieBooking.get());
            return existingMovieBooking;
        }
        else
            return Optional.empty();

    }
}