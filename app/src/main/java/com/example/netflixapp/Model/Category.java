package com.example.netflixapp.Model;

import java.util.List;

public class Category {

    private List<Movie> movies;
    private String name;

    public List<Movie> getMovies() {
        return movies;
    }

    public void setMovies(List<Movie> movies) {
        this.movies = movies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
