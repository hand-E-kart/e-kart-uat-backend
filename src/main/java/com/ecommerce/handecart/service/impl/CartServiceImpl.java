package com.ecommerce.handecart.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecommerce.handecart.entity.Cart;
import com.ecommerce.handecart.entity.Product;
import com.ecommerce.handecart.exception.ResourceNotFoundException;
import com.ecommerce.handecart.repository.CartRepository;
import com.ecommerce.handecart.service.CartService;
import com.ecommerce.handekart.response.ApiResponse;

@Service
public class CartServiceImpl implements CartService{


	@Autowired
	private CartRepository cartRepository;
	
	@Override
	public ResponseEntity<ApiResponse> save(Cart cart) {
	    try {
	        cartRepository.save(cart);
	        ApiResponse response = new ApiResponse(true, "Cart saved successfully", null);
	        return ResponseEntity.status(HttpStatus.CREATED).body(response);
	    } catch (Exception e) {
	        ApiResponse errorResponse = new ApiResponse(false, "Error saving product: " + e.getMessage(), null);
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
	    }
	}

	@Override
	public Cart getById(Long id) {
		Optional<Cart> cart = cartRepository.findById(id);
        if(cart.isPresent()) {
        	return cart.get();
        }else {
        	throw new ResourceNotFoundException("Cart not found with ID: " + id);
        }  
	}

	@Override
	public List<Cart> getAll() {
		return cartRepository.findAll();
	}

}
