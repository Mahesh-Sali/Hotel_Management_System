package com.jsp.HotelManagementSystem.dto;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
public class Admin {
	@Id
	private int admin_id;
	@NotNull(message = "admin name cannot be null")
	@NotBlank(message = "admin name cannote be blank")
	private String admin_name;
	@NotNull(message = "admin email cannot be null")
	@NotBlank(message = "admin email cannote be blank")
	@Email(regexp = "[a-z0-9._%-]+@[a-z0-9.-]+\\.[a-z]{2,4}", message = "Invalid Email")
	private String admin_email;
	@NotNull(message = "admin password cannot be null")
	@NotBlank(message = "admin password cannote be blank")
	private String admin_password;

	@OneToOne
	private Hotel hotel;
}
