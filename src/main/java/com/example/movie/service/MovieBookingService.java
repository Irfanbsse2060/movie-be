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

    public List<MovieBooking> getAllMovieBooking( String searchQuery) {
        if(searchQuery != null && searchQuery.length()>0)
        {
            return movieBookingRepository.findAllByKeyword(searchQuery);
        }

        return movieBookingRepository.findAll();
    }

    public List<MovieBooking> getBookingsOfAMovie(String movieId) {
        return movieBookingRepository.findAllByMovieId(movieId);
    }

    public MovieBooking insertMovieBooking(MovieBooking movieBooking) {
        List<MovieBooking> existingMovieBooking = movieBookingRepository.findAllByMovieIdAndEmail(movieBooking.getMovieId(), movieBooking.getEmail());
        Integer bookingCount = 0;
        for(int i =0; i<existingMovieBooking.size();i++)
        {
            bookingCount += existingMovieBooking.get(i).getNumberOfSeats();
        }
        bookingCount += movieBooking.getNumberOfSeats();
        if(bookingCount>10)
        {
            return movieBooking; // TODO: return error can't have more than 10 seats per movie
        }
        return movieBookingRepository.save(movieBooking);
    }

    public void deleteMovieBooking(Integer movieBookingId) {
        Optional<MovieBooking> movieBooking = movieBookingRepository.findById(movieBookingId);
        movieBooking.ifPresent(movieBookingRepository::delete);
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