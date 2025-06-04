package com.ecommerce.handecart.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecommerce.handecart.entity.Coupon;
import com.ecommerce.handecart.exception.ResourceNotFoundException;
import com.ecommerce.handecart.repository.CouponRepository;
import com.ecommerce.handecart.service.CouponService;
import com.ecommerce.handekart.response.ApiResponse;

@Service
public class CouponServiceImpl implements CouponService{

	@Autowired
	private CouponRepository couponRepository;
	
	@Override
	public ResponseEntity<ApiResponse> save(Coupon coupon) {
		try {
			couponRepository.save(coupon);
			ApiResponse response = new ApiResponse(true, "Coupon saved successfully", null);
			return ResponseEntity.status(HttpStatus.CREATED).body(response);
		}catch(Exception e) {
			ApiResponse errorResponse = new ApiResponse(false, "Error saving coupon: " + e.getMessage(), null);
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
		}
	}

	@Override
	public Coupon getById(Long id) {
		Optional<Coupon> coupon = couponRepository.findById(id);
		if(coupon.isPresent()) {
			return coupon.get();
		}
		throw new ResourceNotFoundException("Coupon not found with this ID: " + id);
	}

	@Override
	public List<Coupon> getAll() {
		return couponRepository.findAll();
	}

}
