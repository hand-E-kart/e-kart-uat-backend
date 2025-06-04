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

import com.ecommerce.handecart.entity.Product;
import com.ecommerce.handecart.exception.ResourceNotFoundException;
import com.ecommerce.handecart.service.ProductService;
import com.ecommerce.handekart.response.ApiResponse;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Product product){
		if(product ==null) {
			return ResponseEntity.badRequest().body("Product can't be null");
		}
		return productService.save(product);	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id){
		try {
			Product product = productService.getById(id);
			return ResponseEntity.ok(new ApiResponse(true, "Product fetched successfully", product));
		}catch(ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(new ApiResponse(false, e.getMessage(), null));
		}
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<?> getAll(){
		List<Product> products=productService.getAll();
		if(products.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(products);
	}
}
