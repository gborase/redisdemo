package com.ganesh.redisDemo.controller;

import com.ganesh.redisDemo.entity.Users;
import com.ganesh.redisDemo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {
@Autowired
    private  UserService userService;
    @GetMapping("/{id}")
    public ResponseEntity<?> findUserById(@PathVariable int id){
        Users userById = userService.getUserById(id);
        return new ResponseEntity<>(userById, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody Users user){
        Users user1 = userService.createUser(user);
        return new ResponseEntity<>(user1, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteUserById(@PathVariable int id){
       userService.deleteUser(id);
        return new ResponseEntity<>("User deleted successfully", HttpStatus.NO_CONTENT);
    }

}
