package com.ganesh.redisDemo.repository;

import com.ganesh.redisDemo.entity.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository<Users,Integer> {

}
