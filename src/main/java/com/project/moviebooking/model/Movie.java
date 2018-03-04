package com.project.moviebooking.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;

@Document(collection = "movie")
@JsonIgnoreProperties(value = {"createdAt"}, allowGetters = true)
public class Movie {
    @Id
    private ObjectId id;

    @Indexed(name = "name",unique = true)// add index when search with movie name
    @NotNull
    @NotBlank
    @Size(min = 2, max=100)
    private String name;

    @Field("description")
    private String description;

    @NotNull
    private Double price;

    private String imageUrl;

    // catagory

    @DBRef
    private Category category;

    @Field("published")
    private LocalDate publicationDate;

    @Field("createdAt")
    private LocalDate createdAt;


}
