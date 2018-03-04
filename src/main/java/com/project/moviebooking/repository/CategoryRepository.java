package com.project.moviebooking.repository;

import com.project.moviebooking.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "categories", path = "categories")
public interface CategoryRepository extends MongoRepository<Category, String> {
    // find all

    public Page<Category> findAll(Pageable pageable);

    // find by name
    public Category findByName(String name);
}