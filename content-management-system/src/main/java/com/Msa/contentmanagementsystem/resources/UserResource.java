package com.Msa.contentmanagementsystem.resources;

import com.Msa.contentmanagementsystem.model.User;
import com.Msa.contentmanagementsystem.service.UserService;
import com.Msa.contentmanagementsystem.vo.UserRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Arrays;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/user")
public class UserResource {

    final UserService userService;

    public UserResource(UserService userService) {
        this.userService = userService;
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Mono<User>> findOne(@PathVariable("id") String id){
        return ResponseEntity.ok(userService.findOne(id));
    }

    @GetMapping
    public ResponseEntity<Flux<User>> findAll(){
        return ResponseEntity.ok(userService.findAll());
    }

    @PostMapping(value = "/create")
    public ResponseEntity<Mono<User>> newUser(UserRequest userRequest){
        return new ResponseEntity<>(userService.create(userRequest), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Mono<Void> removeUser(@PathVariable("id") String id){
        return userService.delete(id);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Mono<User>> updateUser(@PathVariable("id") String id, UserRequest userRequest){
        return new ResponseEntity<>(userService.update(id, userRequest), HttpStatus.OK);
    }
}
