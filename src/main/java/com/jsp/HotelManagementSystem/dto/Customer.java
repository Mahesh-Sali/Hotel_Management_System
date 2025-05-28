package com.jsp.HotelManagementSystem.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Parent;

import lombok.Data;

@Data
@Entity
public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int c_id;
	@NotNull(message = "customer name cannote be null")
	@NotBlank(message = "customer name cannote be blank")
	private String c_name;
	@NotNull(message = "customer address cannote be null")
	@NotBlank(message = "customer address cannote be blank")
	private String c_address;
	@NotNull(message = "customer email cannote be null")
	@NotBlank(message = "customer email cannote be blank")
	@Email(regexp =  "[a-z0-9._%-]+@[a-z0-9.-]+\\.[a-z]{2,4}", message = "Invalid Email")
	@Column(unique = true)
	private String c_email;
	@NotNull(message = "customer password cannote be null")
	@NotBlank(message = "customer password cannote be blank")
	private String c_password;
	@Min(value = 6000000000l)
	@Max(value = 9999999999l)
	private long c_phone;
	@NotNull(message = "customer aadhar cannote be null")
	@NotBlank(message = "customer aadhar cannote be blank")
	@Pattern(regexp = "[1-9][1-9]{ll}", message = "invalid aadhar")//shd give 12 numbers
	private String c_aadhar;
}
