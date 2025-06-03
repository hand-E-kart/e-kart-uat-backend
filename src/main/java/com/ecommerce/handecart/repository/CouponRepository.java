package com.ecommerce.handecart.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ecommerce.handecart.entity.Coupon;

@Repository
public interface CouponRepository extends JpaRepository<Coupon, Long>{

}
