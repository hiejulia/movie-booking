package com.project.moviebooking.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.project.moviebooking.repository.order.ShoppingCart;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Document(collection = "movie")
@JsonIgnoreProperties(value = {"createdAt"}, allowGetters = true)
public class Movie implements Serializable {
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


    @Field("published")
    private LocalDate publicationDate;

    @Field("createdAt")
    private LocalDate createdAt;


    // db ref
    @DBRef
    private Category category;

    // shopping cart
    @DBRef
    private Set<ShoppingCart> shoppingCartSet;


}
