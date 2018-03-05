package com.project.moviebooking.service;


import com.project.moviebooking.controller.CategoryRestController;
import com.project.moviebooking.model.Category;
import com.project.moviebooking.repository.CategoryRepository;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Page;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@DataMongoTest
public class CategoryServiceTest {

    private CategoryService categoryService;

    @Autowired
    private CategoryRepository categoryRepository;

    @Before
    public void setUp(){
//        categoryService = new CategoryService(categoryRepository);
    }

    // after test
    @After
    public void tearDown(){
        categoryRepository.deleteAll();
    }
//    @Test
//    public void test_getAll(){
//        Category category1 = new Category();
//        category1.setName("romance");
//        category1.setId("1");
//
//        Category category2 = new Category();
//        category2.setId("2");
//        category2.setName("action");
//
//        categoryRepository.save(Arrays.asList(category1,category2));
//        List<Category> result = categoryService.getAll();
//        Assert.assertEquals(2, result.size());
//
//    }

    // Test case: get all and sort


}
