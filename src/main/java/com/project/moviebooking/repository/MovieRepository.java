package com.project.moviebooking.repository;


import com.project.moviebooking.model.Category;
import com.project.moviebooking.model.Movie;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Transactional
@RepositoryRestResource(collectionResourceRel = "movies", path = "movies")
@Repository
public interface MovieRepository extends MongoRepository<Movie, String> {
    // find list of movie by category
    List<Movie> findByCategory(Category category);

    // get movie by id
    Movie getMovieById(String id);


}