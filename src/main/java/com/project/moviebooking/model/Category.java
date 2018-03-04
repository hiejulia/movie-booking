package com.project.moviebooking.model;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "category")
@Data
@EqualsAndHashCode
@ToString
public class Category {

    @Id
//    @ObjectId
    private String id;

    private String name;
}
