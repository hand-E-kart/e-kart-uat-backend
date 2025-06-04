package com.ecommerce.handecart.service;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecommerce.handecart.entity.Cart;
import com.ecommerce.handekart.response.ApiResponse;

@Service
public interface CartService {

	ResponseEntity<ApiResponse> save(Cart cart);

	Cart getById(Long id);

	List<Cart> getAll();

}
