package com.Msa.contentmanagementsystem.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;


@Data
@Document(collection = "users")
public class User {

    @Id
    private String identity;

    private String name;

    private Role role;

    @Builder
    public static User newUser(String name, Role role){
        final User user = new User();
        user.setIdentity(UUID.randomUUID().toString());
        user.setName(name);
        user.setRole(role);
        return user;
    }
}
