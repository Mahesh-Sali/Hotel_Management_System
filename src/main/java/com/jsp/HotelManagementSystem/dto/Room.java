package com.jsp.HotelManagementSystem.dto;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.annotations.Parent;

import lombok.Data;

@Data
@Entity
public class Room {
	
	@Id
	private int room_id;
	@NotNull(message = "room no cannot be null")
	@NotBlank(message = "room no cannote be blank")
	private String room_no;
	@NotNull(message = "room room_type cannot be null")
	@NotBlank(message = "room room_type  cannote be blank")
	private String room_type;
	@NotNull(message = "room price cannot be null")
	@NotBlank(message = "room price cannote be blank")
	private int room_price;
	@Min(value = 1)
	@Max(value = 10)
	private int no_beds;
	@Min(value = 1)
	@Max(value = 10)
	private int max_people;
	@NotNull(message = "room avilibility cannot be null")
	@NotBlank(message = "room avilibility cannote be blank")
	@Pattern(regexp = "[Y,N]")
	private String availability;
	@Enumerated(EnumType.STRING)
	private Floor floor;
	@ManyToOne
	private Hotel hotel;
}
