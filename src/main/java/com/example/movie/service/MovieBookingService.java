package com.example.movie.service;

import com.example.movie.exception.ApiRequestException;
import com.example.movie.models.MovieBooking;
import com.example.movie.Repository.MovieBookingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieBookingService {

    private final MovieBookingRepository movieBookingRepository;

    private void validateBooking(MovieBooking movieBooking) {
        String bookingErrorMessage = "You can't book more than 10 seats per movie";
        if (movieBooking.getNumberOfSeats() > 10)
            throw new ApiRequestException(bookingErrorMessage);
        List<MovieBooking> existingMovieBooking = movieBookingRepository.findAllByMovieIdAndEmail(movieBooking.getMovieId(), movieBooking.getEmail());
        Integer bookingCount = 0;
        for (int i = 0; i < existingMovieBooking.size(); i++) {
            bookingCount += existingMovieBooking.get(i).getNumberOfSeats();
        }
        bookingCount += movieBooking.getNumberOfSeats();
        if (bookingCount > 10) {
            throw new ApiRequestException(bookingErrorMessage);
        }
    }

    @Autowired
    public MovieBookingService(MovieBookingRepository movieBookingRepository) {
        this.movieBookingRepository = movieBookingRepository;
    }

    public List<MovieBooking> getAllMovieBooking(String searchQuery) {
        if (searchQuery != null && searchQuery.length() > 0) {
            return movieBookingRepository.findAllByKeyword(searchQuery);
        }
        return movieBookingRepository.findAll();
    }

    public List<MovieBooking> getBookingsOfAMovie(String movieId) {
        return movieBookingRepository.findAllByMovieId(movieId);
    }

    public MovieBooking insertMovieBooking(MovieBooking movieBooking) {
        validateBooking(movieBooking);
        return movieBookingRepository.save(movieBooking);
    }

    public void deleteMovieBooking(Integer movieBookingId) {
        Optional<MovieBooking> movieBooking = movieBookingRepository.findById(movieBookingId);
        movieBooking.ifPresent(movieBookingRepository::delete);
    }

    public MovieBooking updateMovieBooking(MovieBooking movieBooking) {
        Optional<MovieBooking> optionalMovieBooking = movieBookingRepository.findById(movieBooking.getId());
        if (optionalMovieBooking.isPresent()) {
            MovieBooking existingMovieBooking = optionalMovieBooking.get();
            existingMovieBooking.setEmail(movieBooking.getEmail());
            existingMovieBooking.setFirstName(movieBooking.getFirstName());
            existingMovieBooking.setLastName(movieBooking.getLastName());
            existingMovieBooking.setNumberOfSeats(movieBooking.getNumberOfSeats());
            movieBookingRepository.save(existingMovieBooking);
            return existingMovieBooking;
        } else
            throw new ApiRequestException("Booking doesn't exist");
    }
}