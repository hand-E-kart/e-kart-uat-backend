package com.ecommerce.handecart.service;

import org.springframework.http.ResponseEntity;

import com.ecommerce.handecart.entity.User;

public interface UserService {

	ResponseEntity<String> register(User user);

	ResponseEntity<String> login(User user);

}
