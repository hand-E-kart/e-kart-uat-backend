package com.ecommerce.handecart.entity;

import java.time.LocalDate;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table(name="shipping")
public class Shipping {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "orderId", nullable = false, unique = true,referencedColumnName="id", insertable= false, updatable=false)
    private Order order;
    
    private Long orderId;

    @Column(name = "shipping_address", nullable = false, length = 500)
    private String shippingAddress;

    @Column(name = "delivery_date")
    private LocalDate deliveryDate;

    @Column(nullable = false)
    private String status;
    
    @Column(name = "created_date", nullable = false, columnDefinition ="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Date createdDate;
	
	private Long createdBy;
	
	@Column(name = "updated_date", nullable = false, columnDefinition ="TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
	private Date updatedDate;
	
	private Long updatedBy;

}
