package com.project.moviebooking.model.user;
import com.project.moviebooking.model.Address;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.annotation.Id;

@Document(collection = "user")
@Data
public class User {
    @Id
    private String id;

    private String firstname;

    private String lastname;

    private String email;

    private int age;

    private Address address;


}
