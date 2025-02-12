package com.pro.service;

import java.util.List;
import java.util.Optional;

import com.pro.dto.AuthRequest;
import com.pro.dto.AuthResponse;
import com.pro.dto.UserDTO;
import com.pro.pojos.User;

public interface UserServ {
	
	User registerUser(UserDTO userDTO);
    User loginUser(String email, String password);
    List<User> getAllUsers();
    User getUserById(Long id);
    void deleteUser(Long id);

}
