package com.example.movie.models;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieBookingRepository extends JpaRepository<MovieBooking, Integer> {
    public List<MovieBooking> findAllByMovieId(String movieId);
    public MovieBooking findByMovieIdAndAndId(String movieId, Integer id);
}
