package com.Msa.contentmanagementsystem.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;

@Data
@Document(collection = "users")
public class User {

    @Id
    private String identity;

    private String name;

    private Role role;
}
