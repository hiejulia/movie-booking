package com.project.moviebooking.service.impl;


import com.project.moviebooking.model.Category;
import com.project.moviebooking.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository){
        this.categoryRepository= categoryRepository;

    }

    // get all categories
    public List<Category> getAll(){
        return (List<Category>) categoryRepository.findAll();

    }

    // get all and sort by no
    public Page<Apartment> getAllAndSortByNo(Integer page, Integer perPage, String direction, String field) {

        Pageable pageable = new PageRequest(page, perPage, Sort.Direction.fromString(direction), field);

        return apartmentRepository.findAll(pageable);
    }
}
