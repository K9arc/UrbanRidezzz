package com.pro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.pro.dto.UserDTO;
import com.pro.pojos.User;
import com.pro.service.UserServ;


//@RestController
//@CrossOrigin(origins = "http://localhost:3000")
//@RequestMapping("/users")
//public class UserController {
//	
//	@Autowired
//	private UserServ userv;
//	
//	@PostMapping("/login")
//	public ResponseEntity<?> authenticateUser(@RequestBody AuthRequest dto){
//		try {
//			AuthResponse respDto=userv.authenticateUser(dto);
//			return ResponseEntity.ok(respDto);
//		}catch(RuntimeException e) {
//			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(new ApiResponse(e.getMessage()));
//		}
//	}
//	}
	
@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserServ userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody UserDTO userDTO) {
        return userService.registerUser(userDTO);
    }

    @PostMapping("/login")
    public User loginUser(@RequestParam String email, @RequestParam String password) {
        return userService.loginUser(email, password);
    }

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable Long id) {
        return userService.getUserById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}

