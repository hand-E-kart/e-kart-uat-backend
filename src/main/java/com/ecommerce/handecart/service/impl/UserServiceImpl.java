package com.ecommerce.handecart.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecommerce.handecart.entity.User;
import com.ecommerce.handecart.exception.UserAlreadyExistsException;
import com.ecommerce.handecart.repository.UserRepository;
import com.ecommerce.handecart.security.JwtUtil;
import com.ecommerce.handecart.service.UserService;
import com.ecommerce.handekart.response.ApiResponse;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private JwtUtil jwtUtil;

	public ResponseEntity<?> register(User user) {
	    try {
	        Optional<User> existing = userRepository.findByEmail(user.getEmail());
	        if (existing.isPresent()) {
	        	throw new UserAlreadyExistsException("Email already Registered");
	        }
	        user.setCreatedDate(new Date());
	        user.setId(user.getId());
	        userRepository.save(user);
	        ApiResponse response = new ApiResponse(true, "User registered successfully", null);
	        return ResponseEntity.status(HttpStatus.CREATED)
	                             .body(response);
	    } catch (Exception e) {
	        // Log error here if you want
	    	ApiResponse error = new ApiResponse(false, "Error registering user: " + e.getMessage(), null);
	    	 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	    }
	}

	public ResponseEntity<?> login(User loginRequest) {
	    try {
	        Optional<User> user = userRepository.findByEmail(loginRequest.getEmail());   
	        if (user.isPresent() && user.get().getPassword().equalsIgnoreCase(loginRequest.getPassword())) {
	            User userObj = user.get();
	        	String token = jwtUtil.generateToken(user.get().getEmail());
	        	Map<String, Object> payload = new HashMap<>();
	        	payload.put("token", token);
	        	payload.put("user", userObj);
	        	ApiResponse response = new ApiResponse(true,"Login Successful",payload);
	        	return ResponseEntity.ok(response);
	        }
	        ApiResponse errorResponse = new ApiResponse(false, "Invalid email or password", null);
	        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorResponse);
	    } catch (Exception e) {
	    	ApiResponse error = new ApiResponse(false, "Error during login: " + e.getMessage(), null);
	    	return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
	    }
	}

}
