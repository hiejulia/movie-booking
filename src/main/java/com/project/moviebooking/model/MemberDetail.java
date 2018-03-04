package com.project.moviebooking.model;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "memberDetail")
public class MemberDetail {
    @Id
    private ObjectId id;

    @Indexed
    private String name;

    private String superPower;

    private String location;

    }