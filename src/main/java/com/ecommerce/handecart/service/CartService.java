package com.ecommerce.handecart.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ecommerce.handecart.entity.Cart;

public interface CartService {

	ResponseEntity<?> save(Cart cart);

	Cart getById(Long id);

	List<Cart> getAll();

}
