package com.ecommerce.handecart.service.impl;

import java.util.Date;
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
	    	//for update
	    	boolean isUpdate = false;
	    	if(product.getId()!=null && product.getId() > 0) {
	    		Product existingProduct = productRepository.findById(product.getId()).orElse(product);
	    		if(existingProduct!=null) {
	    			existingProduct.setDescription(product.getDescription());
	    			existingProduct.setName(product.getName());
	    			existingProduct.setPrice(product.getPrice());
	    			existingProduct.setStock(product.getStock());
	    			existingProduct.setUpdatedDate(new Date());
	    			productRepository.save(existingProduct);
	    			isUpdate= true;
	    		}
	    	}else {
	    		product.setCreatedDate(new Date());
		    	product.setUpdatedDate(new Date());
		        productRepository.save(product);
	    	}
	    	ApiResponse response = new ApiResponse(true, isUpdate ? "Product updated successfully" : "Product saved successfully", null);
	        return ResponseEntity.status(isUpdate ? HttpStatus.OK : HttpStatus.CREATED).body(response);
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
