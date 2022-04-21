package com.example.movie.models;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {
    private String id;
    private String title;
    private String overview;
    private String poster_path;
    private String original_title;
    private String release_date;
    private String vote_average;
    private String original_language;
    private Boolean adult;
    private Float popularity;
    private Integer vote_count;
    private Boolean video;
    private String status;
    private Integer runtime;
    private Long revenue;
    private String homepage;
    private String tagline;
    private List<Genre> genres;
    private List<ProductionCountry> production_countries;
    private List<ProductionCompany> production_companies;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class Genre {
    private Long id;
    private  String name;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class ProductionCompany {
    private Long id;
    private  String logo_path;
    private  String name;
    private  String origin_country;
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class ProductionCountry {
    private Long id;
    private  String name;
}
