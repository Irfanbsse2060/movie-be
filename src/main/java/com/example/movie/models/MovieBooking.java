package com.example.movie.models;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table
@Data
@NoArgsConstructor
public class MovieBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private  Integer id;
    private  Integer numberOfSeats;
    private  String email;
    private  String firstName;
    private  String lastName;
    private  String movieId;
    private  String bookedDate;
}
