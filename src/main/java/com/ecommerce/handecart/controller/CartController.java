package com.ecommerce.handecart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.handecart.entity.Cart;
import com.ecommerce.handecart.entity.Product;
import com.ecommerce.handecart.exception.ResourceNotFoundException;
import com.ecommerce.handecart.service.CartService;
import com.ecommerce.handekart.response.ApiResponse;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/cart")
public class CartController {
	
	@Autowired
	private CartService cartService;
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Cart cart){
		if(cart ==null) {
			return ResponseEntity.badRequest().body("Cart can't be null");
		}
		return cartService.save(cart);	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id){
		try {
			Cart cart = cartService.getById(id);
			return ResponseEntity.ok(new ApiResponse(true, "Cart fetched successfully", cart));
		}catch(ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ApiResponse(false, e.getMessage(), null));
		}
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Cart>> getAll(){
		List<Cart> carts=cartService.getAll();
		if(carts.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(carts);
	}

}
