package com.jsp.HotelManagementSystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.HotelManagementSystem.dto.Booking;
import com.jsp.HotelManagementSystem.service.Bookingservice;
import com.jsp.HotelManagementSystem.util.Responsestructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/booking")
public class Bookingcontroller 
{
	@Autowired
    private Bookingservice bookingservice;
	
	@ApiOperation(value = "save booking",notes = "api is used for save booking")
	@ApiResponses(value = {@ApiResponse(code = 201 ,message = "booking sucessfully created"),
			@ApiResponse(code = 404, message = "booking is not saved give proper input")})
	@PostMapping
	public ResponseEntity<Responsestructure<Booking>> saveBooking(@RequestBody Booking booking,@RequestParam int cid,@RequestParam int rid)
	{
		return bookingservice.saveBooking(booking, cid, rid);
	}
	@ApiOperation(value = "update booking",notes = "api is used for update booking")
	@ApiResponses(value = {@ApiResponse(code = 200 ,message = "booking sucessfully updated"),
			@ApiResponse(code = 404, message = "booking is not updated give proper input")})
	@PutMapping
	public ResponseEntity<Responsestructure<Booking>> updateBooking(@RequestBody Booking booking,@RequestParam int bid)
	{
		return bookingservice.updateBooking(booking, bid);
	}
	@ApiOperation(value = "delete booking",notes = "api is used for delete booking")
	@ApiResponses(value = {@ApiResponse(code = 200 ,message = "booking sucessfully deleted"),
			@ApiResponse(code = 404, message = "booking is not deleted give proper input")})
	@DeleteMapping
	public ResponseEntity<Responsestructure<Booking>> deleteBooking(@RequestParam int bid)
	{
		return bookingservice.deleteBooking(bid);
	}
	@ApiOperation(value = "get booking by id",notes = "api is used for get booking based on id")
	@ApiResponses(value = {@ApiResponse(code = 302 ,message = "booking data found sucessfully"),
			@ApiResponse(code = 404, message = "booking is not found give proper input")})
	@GetMapping("/bookingbyid")
	public ResponseEntity<Responsestructure<Booking>> getBookingbyid(@RequestParam int bid)
	{
		return bookingservice.getBookingbyid(bid);
	}
	@ApiOperation(value = "getAll booking",notes = "api is used for get all booking")
	@ApiResponses(value = {@ApiResponse(code = 302 ,message = "booking data found sucessfully"),
			@ApiResponse(code = 404, message = "booking is not found give proper input")})
	@GetMapping("/getallbooking")
	public ResponseEntity<Responsestructure<List<Booking>>> getallBooking()
	{
		return bookingservice.getallbooking();
	}
	@ApiOperation(value = "close booking",notes = "api is used for close booking")
	@ApiResponses(value = {@ApiResponse(code = 200 ,message = "booking sucessfully closed"),
			@ApiResponse(code = 404, message = "booking is not closed give proper input")})
	@PutMapping("/closebooking")
	public ResponseEntity<Responsestructure<Booking>> closeBooking(@RequestParam int bid)
	{
		return bookingservice.closeBooking(bid);
	}
	
}
