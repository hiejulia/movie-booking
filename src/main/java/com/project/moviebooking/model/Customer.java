package com.project.moviebooking.model;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;

import java.util.Date;


public class Customer {

    @Id
    private String id;

    private String name;

    private String email;

    @CreatedDate
    private Date createdDate;


}
