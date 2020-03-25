package com.Msa.contentmanagementsystem.repository;

import com.Msa.contentmanagementsystem.model.Category;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CategoryRepository extends MongoRepository<Category, String> {


}
