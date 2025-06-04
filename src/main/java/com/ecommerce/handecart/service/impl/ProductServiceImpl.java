package com.ecommerce.handecart.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecommerce.handecart.entity.Product;
import com.ecommerce.handecart.exception.ResourceNotFoundException;
import com.ecommerce.handecart.repository.ProductRepository;
import com.ecommerce.handecart.service.ProductService;
import com.ecommerce.handekart.response.ApiResponse;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepository;
	
	@Override
	public ResponseEntity<ApiResponse> save(Product product) {
	    try {
	        productRepository.save(product);
	        ApiResponse response = new ApiResponse(true, "Product saved successfully", null);
	        return ResponseEntity.status(HttpStatus.CREATED).body(response);
	    } catch (Exception e) {
	        ApiResponse errorResponse = new ApiResponse(false, "Error saving product: " + e.getMessage(), null);
	        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
	    }
	}

	@Override
	public Product getById(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()) {
        	return product.get();
        }else {
        	throw new ResourceNotFoundException("Product not found with ID: " + id);
        }  
    }

	@Override
	public List<Product> getAll() {
		return productRepository.findAll();
	}

}
