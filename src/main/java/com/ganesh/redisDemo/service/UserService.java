package com.ganesh.redisDemo.service;

import com.ganesh.redisDemo.entity.Users;
import com.ganesh.redisDemo.repository.UserRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public Users getUserById(int id){
        return userRepository.findById(id).orElse(null);
    }
    public Users createUser(Users user){
      return   userRepository.save(user);
    }

    public void deleteUser(int id){
        userRepository.deleteById(id);
    }


}
