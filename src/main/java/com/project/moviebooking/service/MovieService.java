package com.project.moviebooking.service;



import com.project.moviebooking.model.Movie;

import java.util.List;

public interface MovieService {

    List<Movie> listAll();

    Movie getById(String id);

    Movie saveOrUpdate(Product product);

    void delete(String id);

    Movie saveOrUpdateProductForm(ProductForm productForm);


}