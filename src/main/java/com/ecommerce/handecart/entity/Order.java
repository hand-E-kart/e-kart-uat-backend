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
@Table(name = "orders") 
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "userId", nullable = false,referencedColumnName="id", insertable= false, updatable=false)
    private User user;
    
    private Long userId;

    @Column(name = "order_date", nullable = false)
    private LocalDateTime orderDate;

    @Column(name = "total_amount", nullable = false)
    private BigDecimal totalAmount;

    @Column(nullable = false)
    private String status;

    @Column(name = "payment_status", nullable = false)
    private String paymentStatus;

    @Column(name = "created_date", nullable = false, columnDefinition ="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdDate;
	
	private Long createdBy;
	
	@Column(name = "updated_date", nullable = false, columnDefinition ="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date updatedDate;
	
	private Long updatedBy;
}
