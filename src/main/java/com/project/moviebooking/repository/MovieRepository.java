package com.project.moviebooking.repository;


import com.project.moviebooking.model.Category;
import com.project.moviebooking.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "movies", path = "movies")
public interface MovieRepository extends MongoRepository<Movie, String> {
    // find list of movie by category
    List<Movie> findByCategory(Category category);
}