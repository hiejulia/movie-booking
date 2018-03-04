package com.project.moviebooking.repository;

import com.project.moviebooking.model.Customer;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "customer",path = "customer")
public interface CustomerRepository extends MongoRepository<Customer,String>{
    // search for customer by customer email
    List<Customer> findByEmail(@Param("email") String email);
}
