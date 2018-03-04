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
    @Test
    public void test_getAll(){
        Category category1 = new Category();
        category1.setName("romance");
        category1.setId("1");

        Category category2 = new Category();
        category2.setId("2");
        category2.setName("action");

        categoryRepository.save(Arrays.asList(category1,category2));
        List<Category> result = categoryService.getAll();
        Assert.assertEquals(2, result.size());

    }

    // Test case: get all and sort

    @Test
    public void test_getAllAndSort() {
        Apartment apartment1 = new Apartment();
        apartment1.setNo(1L);
        apartment1.setName("A 1");
        apartment1.setAddress("ADDR 1");

        Apartment apartment2 = new Apartment();
        apartment2.setNo(2L);
        apartment2.setName("A 2");
        apartment2.setAddress("ADDR 2");

        Apartment apartment3 = new Apartment();
        apartment3.setNo(3L);
        apartment3.setName("A 3");
        apartment3.setAddress("ADDR 3");

        apartmentRepository.save(Arrays.asList(apartment1, apartment2, apartment3));

        Page<Apartment> pageResult = apartmentService.getAllAndSortByNo(0, 10, "DESC", "no");
        List<Apartment> listResult = pageResult.getContent();

        Assert.assertEquals(apartment3.getNo(), listResult.get(0).getNo());
        Assert.assertEquals(apartment2.getNo(), listResult.get(1).getNo());
        Assert.assertEquals(apartment1.getNo(), listResult.get(2).getNo());
    }
}
