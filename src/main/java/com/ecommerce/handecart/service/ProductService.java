package com.ecommerce.handecart.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ecommerce.handecart.entity.Product;

public interface ProductService {

	ResponseEntity<?> save(Product product);

	Product getById(Long id);

	List<Product> getAll();

}
