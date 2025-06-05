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

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "orderId", nullable = false,referencedColumnName="id", insertable= false, updatable=false)
	private Order order;
	
	private Long orderId;

	@Column(name = "payment_date", nullable = false)
	private LocalDateTime paymentDate;

	@Column(nullable = false)
	private BigDecimal amount;

	@Column(name = "payment_method", nullable = false)
	private String paymentMethod;

	@Column(nullable = false)
	private String status;
	
	@Column(name = "created_date", nullable = false, columnDefinition ="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date createdDate;
	
	private Long createdBy;
	
	@Column(name = "updated_date", nullable = false, columnDefinition ="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date updatedDate;
	
	private Long updatedBy;

}
