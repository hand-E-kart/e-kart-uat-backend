package com.ecommerce.handecart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.handecart.entity.Cart;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

}
