package com.ecommerce.handecart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.handecart.entity.Shipping;

@Repository
public interface ShippingRepository extends JpaRepository<Shipping, Long> {

}
