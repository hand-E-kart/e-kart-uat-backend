package com.ecommerce.handecart.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.ecommerce.handecart.entity.Coupon;

public interface CouponService {

	ResponseEntity<?> save(Coupon coupon);

	Coupon getById(Long id);

	List<Coupon> getAll();

}
