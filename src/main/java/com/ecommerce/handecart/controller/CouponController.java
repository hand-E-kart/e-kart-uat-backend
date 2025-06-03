package com.ecommerce.handecart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.handecart.entity.Cart;
import com.ecommerce.handecart.entity.Coupon;
import com.ecommerce.handecart.exception.ResourceNotFoundException;
import com.ecommerce.handecart.service.CartService;
import com.ecommerce.handecart.service.CouponService;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/coupon")
public class CouponController {
	@Autowired
	private CouponService couponService;
	
	@PostMapping("/save")
	public ResponseEntity<?> save(@RequestBody Coupon coupon){
		if(coupon ==null) {
			return ResponseEntity.badRequest().body("Cart can't be null");
		}
		return couponService.save(coupon);	
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id){
		try {
			Coupon coupon = couponService.getById(id);
			return ResponseEntity.ok(coupon);
		}catch(ResourceNotFoundException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
		}
	}
	
	@GetMapping("/getAll")
	public ResponseEntity<List<Coupon>> getAll(){
		List<Coupon> coupons=couponService.getAll();
		if(coupons.isEmpty()) {
			return ResponseEntity.noContent().build();
		}
		return ResponseEntity.ok(coupons);
	}
}
