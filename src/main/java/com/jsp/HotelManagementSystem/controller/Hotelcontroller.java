package com.jsp.HotelManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.HotelManagementSystem.dto.Hotel;
import com.jsp.HotelManagementSystem.service.Hotelservice;
import com.jsp.HotelManagementSystem.util.Responsestructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController //handle the req coming in the form of JSON object.
@RequestMapping("/hotel")
public class Hotelcontroller 
{
	@Autowired
	private Hotelservice hotelservice;

	@ApiOperation(value = "save hotel",notes = "api is used for save hotel")
	@ApiResponses(value = {@ApiResponse(code = 201 ,message = "hotel sucessfully created"),
			@ApiResponse(code = 404, message = "hotel is not saved give proper input")})
	@PostMapping
	public ResponseEntity<Responsestructure<Hotel>> saveHotel(@RequestBody Hotel hotel) {
		return hotelservice.saveHotel(hotel);

	}
	@ApiOperation(value = "update hotel",notes = "api is used for update hotel")
	@ApiResponses(value = {@ApiResponse(code = 200 ,message = "hotel sucessfully updated"),
			@ApiResponse(code = 404, message = "hotel is not updated give proper input")})
	@PutMapping
	public ResponseEntity<Responsestructure<Hotel>> updateHotel(@RequestParam int hid, @RequestBody Hotel hotel) {
		return hotelservice.updateHotel(hid, hotel);

	}
	@ApiOperation(value = "delete hotel",notes = "api is used for delete hotel")
	@ApiResponses(value = {@ApiResponse(code = 200 ,message = "hotel sucessfully deleted"),
			@ApiResponse(code = 404, message = "hotel is not deleted give proper input")})
	@DeleteMapping
	public ResponseEntity<Responsestructure<Hotel>> deleteHotel(@RequestParam int hid) {
		return hotelservice.deleteHotel(hid);

	}
	
	@ApiOperation(value = "get hotel by id",notes = "api is used to get hotel details based on id")
	@ApiResponses(value = {@ApiResponse(code = 302 ,message = "hotel sucessfully found"),
			@ApiResponse(code = 404, message = "hotel data not found give proper input")})
	@GetMapping
	public ResponseEntity<Responsestructure<Hotel>> gethotelbyid(@RequestParam int hid) {
		return hotelservice.getHotelbyid(hid);

	}
 
}
