package com.project.moviebooking.model;
//import javax.persistence.Id;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;


@Data
public class Address {

        private String streetNum;

        private String locality;

        private String state;

        private String country;

        private int pincode;
}
