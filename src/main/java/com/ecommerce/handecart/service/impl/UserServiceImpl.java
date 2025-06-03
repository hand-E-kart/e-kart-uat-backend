package com.ecommerce.handecart.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecommerce.handecart.entity.User;
import com.ecommerce.handecart.exception.UserAlreadyExistsException;
import com.ecommerce.handecart.repository.UserRepository;
import com.ecommerce.handecart.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	public ResponseEntity<String> register(User user) {
	    try {
	        Optional<User> existing = userRepository.findByEmail(user.getEmail());
	        if (existing.isPresent()) {
	        	throw new UserAlreadyExistsException("Email already Registered");
	        }
	        userRepository.save(user);
	        return ResponseEntity.status(HttpStatus.CREATED)
	                             .body("User registered successfully");
	    } catch (Exception e) {
	        // Log error here if you want
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                             .body("Error registering user: " + e.getMessage());
	    }
	}

	public ResponseEntity<String> login(User loginRequest) {
	    try {
	        Optional<User> user = userRepository.findByEmail(loginRequest.getEmail());
	        if (user.isPresent() && user.get().getPassword().equals(loginRequest.getPassword())) {
	            return ResponseEntity.ok("Login successful");
	        }
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
	                             .body("Invalid email or password");
	    } catch (Exception e) {
	        // add logger 
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                             .body("Error during login: " + e.getMessage());
	    }
	}

}
