package com.ecommerce.handecart.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "payments")
public class Payment {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "order_id", nullable = false)
	private Order order;

	@Column(name = "payment_date", nullable = false)
	private LocalDateTime paymentDate;

	@Column(nullable = false)
	private BigDecimal amount;

	@Column(name = "payment_method", nullable = false)
	private String paymentMethod;

	@Column(nullable = false)
	private String status;
	
	private Date createdDate;
	
	private Long createdBy;
	
	private Date updatedDate;
	
	private Long updatedBy;

}
