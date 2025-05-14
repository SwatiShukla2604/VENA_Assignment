package com.assignment.usercrudwithdb.repository;


import com.assignment.usercrudwithdb.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
}

