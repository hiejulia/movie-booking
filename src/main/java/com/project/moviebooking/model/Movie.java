package com.project.moviebooking.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Document

public class Movie {
    @Id
    private ObjectId id;

    private String name;

    private String description;

    private BigDecimal price;

    private String imageUrl;
}
