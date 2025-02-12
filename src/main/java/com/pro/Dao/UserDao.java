package com.pro.Dao;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pro.pojos.User;

public interface UserDao extends JpaRepository<User,Long> {

	 // Find a user by email
    Optional<User> findByEmail(String email);

    // Check if a user exists by email
    boolean existsByEmail(String email);
}
