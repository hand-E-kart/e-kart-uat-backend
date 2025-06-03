package com.ecommerce.handecart.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Email
    @Column(unique = true, nullable = false)
	private String email;
	
	@NotBlank
	private String name;
	
	@Column(nullable = false)
	private String password;
	
	private String phone;
	
	private String address; // multiple address with address category
	
	private int roleId;
	
	private Boolean acceptTerm;
	
	private Boolean acceptMarketing;
	
	private Date createdDate;
	
	private Long createdBy;
	
	private Date updatedDate;
	
	private Long updatedBy;
}
