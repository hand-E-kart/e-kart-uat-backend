package com.ecommerce.handecart.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ecommerce.handecart.entity.Product;
import com.ecommerce.handekart.response.ApiResponse;

public interface ProductService {

	ResponseEntity<ApiResponse> save(Product product);

	Product getById(Long id);

	List<Product> getAll();

}
