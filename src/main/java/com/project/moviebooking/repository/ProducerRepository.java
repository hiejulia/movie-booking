package com.project.moviebooking.repository;

import com.project.moviebooking.model.Movie;
import com.project.moviebooking.model.Producer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "authors", path = "authors")
public interface ProducerRepository extends MongoRepository<Producer, String> {
    // find one producer by movie
    Producer findOneByMovies(Movie movie);

    // get all producers


    // find one producer by id
}