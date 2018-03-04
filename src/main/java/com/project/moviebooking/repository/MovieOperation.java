package com.project.moviebooking.repository;

import java.util.List;

public interface MovieOperation {
    // find all tags
    List<String> findAllTags();

    // find tags by fragment
    List<String> findTagsByFragment(String fragment);
}
