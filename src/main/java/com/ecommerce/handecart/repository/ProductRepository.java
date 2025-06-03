package com.ecommerce.handecart.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ecommerce.handecart.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
