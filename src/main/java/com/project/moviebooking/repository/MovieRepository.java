package com.project.moviebooking.repository;


import com.project.moviebooking.model.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, String> {
}