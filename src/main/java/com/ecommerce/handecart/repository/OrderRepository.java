package com.ecommerce.handecart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.handecart.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long>{

}
