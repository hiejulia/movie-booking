package com.project.moviebooking.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document

public class Producer {
    @Id
    private String id;

    private String name;

    private String address;

    // db ref
    @DBRef
    private List<Movie> movies;





}
