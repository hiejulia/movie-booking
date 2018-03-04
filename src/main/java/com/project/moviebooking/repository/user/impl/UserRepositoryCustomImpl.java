package com.project.moviebooking.repository.user.impl;

import com.project.moviebooking.model.user.User;
import com.project.moviebooking.repository.user.UserRepositoryCustom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;


public class UserRepositoryCustomImpl implements UserRepositoryCustom{
    private final MongoOperations mongoOperations;

    @Autowired
    public UserRepositoryCustomImpl(MongoOperations mongoOperations){
        this.mongoOperations = mongoOperations;


    }

    @Override
    public List<User> fetchUserByAgeAndLocality(int age, String locality) {

        Query searchQuery = new Query();
        searchQuery.addCriteria(Criteria.where("age").is(age));
        searchQuery.addCriteria(Criteria.where("address.locality").is(locality));

        List<User> users = mongoOperations.find(searchQuery,User.class);

        return users;
    }
}
