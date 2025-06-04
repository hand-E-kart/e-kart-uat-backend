package com.ecommerce.handecart.service;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecommerce.handecart.entity.User;

@Service
public interface UserService {

	ResponseEntity<?> register(User user);

	ResponseEntity<?> login(User user);

}
