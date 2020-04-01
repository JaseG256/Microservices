package com.Msa.contentmanagementsystem.service;

import com.Msa.contentmanagementsystem.model.User;
import com.Msa.contentmanagementsystem.repository.UserRepository;
import com.Msa.contentmanagementsystem.vo.UserRequest;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public Mono<User> update(String id, UserRequest userRequest){
        return this.userRepository.findById(id).flatMap(user -> {
            user.setName(userRequest.getName());
            user.setRole(userRequest.getRole());
            return userRepository.save(user);
        });
    }

    public Mono<User> create(UserRequest userRequest){
        final User user = new User();
        user.setIdentity(UUID.randomUUID().toString());
        user.setName(userRequest.getName());
        user.setRole(userRequest.getRole());
        return userRepository.save(user);
    }

    public Mono<Void> delete(String id){
        return this.userRepository.deleteById(id);
    }

    public Flux<User> findAll(){
        return this.userRepository.findAll();
    }

    public Mono<User> findOne(String id){
        return this.userRepository.findById(id);
    }

}
