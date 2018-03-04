package com.project.moviebooking.repository.user;

import com.project.moviebooking.model.user.User;

import java.util.List;

public interface UserRepositoryCustom {
    public List<User> fetchUserByAgeAndLocality(int age, String locality);
}
