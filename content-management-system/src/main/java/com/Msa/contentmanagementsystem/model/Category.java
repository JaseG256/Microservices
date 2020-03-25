package com.Msa.contentmanagementsystem.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Id;
import java.util.UUID;

@Data
@Document(collection = "categories")
public class Category {

    @Id
    private String id;

    private String name;

    @Builder
    public static Category newCategory(String name){
        final Category category = new Category();
        category.setId(UUID.randomUUID().toString());
        category.setName(name);
        return category;
    }
}
