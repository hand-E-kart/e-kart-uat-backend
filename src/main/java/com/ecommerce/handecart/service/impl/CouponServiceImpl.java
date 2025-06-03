package com.ecommerce.handecart.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.ecommerce.handecart.entity.Coupon;
import com.ecommerce.handecart.repository.CouponRepository;
import com.ecommerce.handecart.service.CouponService;

@Service
public class CouponServiceImpl implements CouponService{

	@Autowired
	private CouponRepository couponRepository;
	
	@Override
	public ResponseEntity<?> save(Coupon coupon) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Coupon getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Coupon> getAll() {
		return couponRepository.findAll();
	}

}
