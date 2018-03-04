package com.project.moviebooking.model.user;
import com.project.moviebooking.model.Address;
import com.project.moviebooking.repository.order.ShoppingCart;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.DBRef;
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
import java.io.Serializable;
import java.util.*;


@Document(collection = "user")
@Data
public class User implements Serializable {
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

    // db ref :
    @DBRef
    private Set<ShoppingCart> shoppingCarts = new HashSet<>();



}
