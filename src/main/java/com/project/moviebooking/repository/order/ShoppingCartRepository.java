package com.project.moviebooking.repository.order;


import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;



public interface ShoppingCartRepository extends MongoRepository<ShoppingCart, String> {

    List<ShoppingCart> findByStatus(String status);
}