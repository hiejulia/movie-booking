package com.project.moviebooking.model.order;

import java.util.List;

import com.project.moviebooking.model.Customer;
import com.project.moviebooking.model.Movie;
import org.springframework.data.annotation.Id;



public class Order {
    @Id
    private String id;

    private Customer customer;

    private List<Movie> movies;


}
