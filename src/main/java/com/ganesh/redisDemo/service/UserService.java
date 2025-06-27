package com.ganesh.redisDemo.service;

import com.ganesh.redisDemo.entity.Users;
import com.ganesh.redisDemo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private  UserRepository userRepository;
    @Cacheable(value="user",key = "#id")
    public Users getUserById(int id){
        return userRepository.findById(id).orElse(null);
    }
    @CachePut(value="user",key = "#user.id")
    public Users createUser(Users user){
      return   userRepository.save(user);
    }

@CacheEvict(value="user",key = "#id")
    public void deleteUser(int id){
        userRepository.deleteById(id);
    }


}
