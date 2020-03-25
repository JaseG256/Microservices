package com.Msa.contentmanagementsystem.service;

import com.Msa.contentmanagementsystem.model.User;
import com.Msa.contentmanagementsystem.repository.UserRepository;
import com.Msa.contentmanagementsystem.vo.UserRequest;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public User update(String id, UserRequest userRequest){
        final User user = this.userRepository.findById(id).get();
        user.setIdentity(userRequest.getIdentity());
        user.setName(userRequest.getName());
        user.setRole(userRequest.getRole());
        return this.userRepository.save(user);
    }

    public User create(UserRequest userRequest){
        User user = new User();
        user.setIdentity(UUID.randomUUID().toString());
        user.setIdentity(userRequest.getIdentity());
        user.setName(userRequest.getName());
        user.setRole(userRequest.getRole());
        return this.userRepository.save(user);
    }

    public void delete(String id){
        final User user = this.userRepository.findById(id).isPresent() ?
                this.userRepository.findById(id).get() : new User();
        this.userRepository.delete(user);
    }

    public Iterable<User> findAll(){
        return this.userRepository.findAll();
    }

    public User findOne(String id){
        return this.userRepository.findById(id).get();
    }

}
