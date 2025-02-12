package com.pro.service;

import com.pro.Dao.UserDao;
import com.pro.dto.UserDTO;
import com.pro.pojos.User;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Transactional
@Service
public class UserServImpl implements UserServ {

    @Autowired
    private UserDao userRepository;

    
    private PasswordEncoder passwordEncoder; // Autowire the PasswordEncoder

    @Override
    public User registerUser(UserDTO userDTO) {
        // Check if the email is already registered
        if (userRepository.findByEmail(userDTO.getEmail()).isPresent()) {
            throw new RuntimeException("Email already registered");
        }

        // Create a new User entity from the DTO
        User user = new User();
        user.setFname(userDTO.getFname());
        user.setLname(userDTO.getLname());
        user.setEmail(userDTO.getEmail());
        //user.setPassword(passwordEncoder.encode(userDTO.getPassword())); // Encode the password
        user.setPassword(userDTO.getPassword());
        user.setRole(userDTO.getRole());
        user.setDrivingLicence(userDTO.getDrivingLicence());
        user.setPhoneNo(userDTO.getPhoneNo());
        user.setAddress(userDTO.getAddress());
        user.setCity(userDTO.getCity());
        user.setState(userDTO.getState());
        user.setZipCode(userDTO.getZipCode());

        // Save the user to the database
        return userRepository.save(user);
    }

    @Override
    public User loginUser(String email, String password) {
        // Find the user by email
        Optional<User> userOptional = userRepository.findByEmail(email);
        if (userOptional.isEmpty()) {
            throw new RuntimeException("User not found");
        }
         
        User user = userOptional.get();
        if(!user.getPassword().equals(password)) {
        	throw new RuntimeException("Invalid credentials");
        }
        // Verify the password
        //if (!passwordEncoder.matches(password, user.getPassword()))
//        {
//            throw new RuntimeException("Invalid password");
//        }

        // Return the user if login is successful
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found"));
    }

    @Override
    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User not found");
        }
        userRepository.deleteById(id);
    }
}