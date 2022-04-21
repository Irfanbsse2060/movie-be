package com.example.movie.Repository;

import com.example.movie.models.MovieBooking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MovieBookingRepository extends JpaRepository<MovieBooking, Integer> {
    List<MovieBooking> findAllByMovieId(String movieId);

    List<MovieBooking> findAllByMovieIdAndEmail(String movieId, String email);

    @Query(value = "select * from movie_booking mb where mb.email ilike %:keyword% or mb.first_name ilike %:keyword% or mb.last_name ilike %:keyword%", nativeQuery = true)
    List<MovieBooking> findAllByKeyword(@Param("keyword") String keyword);
}
