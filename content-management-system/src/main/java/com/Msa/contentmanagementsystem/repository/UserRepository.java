package com.Msa.contentmanagementsystem.repository;

import com.Msa.contentmanagementsystem.model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepository extends MongoRepository<User, String> {
}