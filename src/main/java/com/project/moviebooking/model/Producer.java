package com.project.moviebooking.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "producer")
public class Producer {
    @Id
    private String id;

    @Indexed
    private String name;

    private String address;

    // db ref
    @DBRef
    private List<Movie> movies;





}
