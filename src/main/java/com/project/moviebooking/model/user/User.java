package com.project.moviebooking.model.user;
import com.project.moviebooking.model.Address;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;

import javax.validation.constraints.NotNull;
import java.util.*;


@Document(collection = "user")
@Data
public class User {
    @Id
    private String id;

    @NotNull
    private String firstname;

    @NotNull
    private String lastname;

    @Indexed(unique = true)
    private String email;

    private int age;

    private Address address;


}
