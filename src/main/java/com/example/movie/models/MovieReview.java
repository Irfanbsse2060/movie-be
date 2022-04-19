package com.example.movie.models;

import lombok.Data;

@Data
public class MovieReview {
    private String author;
    private String url;
    private String updated_at;
    private String id;
    private String created_at;
    private String content;
    private AuthorDetail author_details;
}

@Data
class AuthorDetail {
    private String name;
    private String url;
    private String username;
    private String avatar_path;
    private String rating;
}



