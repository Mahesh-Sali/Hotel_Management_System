package com.jsp.HotelManagementSystem.controller;

import java.util.List;

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

import com.jsp.HotelManagementSystem.dao.Roomdao;
import com.jsp.HotelManagementSystem.dto.Room;
import com.jsp.HotelManagementSystem.service.Roomservice;
import com.jsp.HotelManagementSystem.util.Responsestructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/room")
public class Roomcontroller 
{
	@Autowired
    private Roomservice roomservice;
    
	@ApiOperation(value = "save room",notes = "api is used for save room")
	@ApiResponses(value = {@ApiResponse(code = 201 ,message = "room sucessfully created"),
			@ApiResponse(code = 404, message = "room is not saved give proper input")})
	@PostMapping
    public ResponseEntity<Responsestructure<Room>> saveRoom(@RequestBody Room room,@RequestParam int hid)
    {
    	return roomservice.saveRoom(room, hid);
    }
	@ApiOperation(value = "update room",notes = "api is used for update room")
	@ApiResponses(value = {@ApiResponse(code = 200 ,message = "room sucessfully updated"),
			@ApiResponse(code = 404, message = "room is not updated give proper input")})
	@PutMapping
    public ResponseEntity<Responsestructure<Room>> updateRoom(@RequestParam int rid,@RequestBody Room room)
    {
    	return roomservice.updateRoom(rid, room);
    }
	@ApiOperation(value = "delete room",notes = "api is used for delete room")
	@ApiResponses(value = {@ApiResponse(code = 200 ,message = "room sucessfully deleted"),
			@ApiResponse(code = 404, message = "room is not deleted give proper input")})
	@DeleteMapping
	public ResponseEntity<Responsestructure<Room>> deleteRoom(@RequestParam int rid)
	{
		return roomservice.deleteRoom(rid);
	}
	@ApiOperation(value = "get room by id",notes = "api is used for get room details based on id")
	@ApiResponses(value = {@ApiResponse(code = 302 ,message = "room sucessfully found"),
			@ApiResponse(code = 404, message = "room data is not found give proper input")})
	@GetMapping
	public ResponseEntity<Responsestructure<Room>> getRoombyid(@RequestParam int rid)
	{
		return roomservice.getRoombyid(rid);
	}
	@ApiOperation(value = "get room by room no",notes = "api is used for get room details based on room no")
	@ApiResponses(value = {@ApiResponse(code = 302 ,message = "room sucessfully found"),
			@ApiResponse(code = 404, message = "room is not found give proper input")})
	@GetMapping("/roombyno")
	public ResponseEntity<Responsestructure<Room>> getRoombyno(@RequestParam String room_no)
	{
		return roomservice.getRoombyno(room_no);
	}
	@ApiOperation(value = "get room by room type",notes = "api is used for get room details based on room type")
	@ApiResponses(value = {@ApiResponse(code = 302 ,message = "room sucessfully found"),
			@ApiResponse(code = 404, message = "room is not found give proper input")})
	@GetMapping("/roombytype")
	public ResponseEntity<Responsestructure<List<Room>>> getRoombytype(@RequestParam String room_type)
	{
		return roomservice.getRoombytype(room_type);
	}
	@ApiOperation(value = "get room by room avilibility",notes = "api is used for get room details based on room avilibility")
	@ApiResponses(value = {@ApiResponse(code = 302 ,message = "room sucessfully found"),
			@ApiResponse(code = 404, message = "room is not found give proper input")})
	@GetMapping("/roombyavailability")
	public ResponseEntity<Responsestructure<List<Room>>> getRoomsbyavailability(@RequestParam String availability)
	{
		return roomservice.getRoombyavailability(availability);
	}
	@ApiOperation(value = "get room by room no",notes = "api is used for get room details based on room no")
	@ApiResponses(value = {@ApiResponse(code = 302 ,message = "room sucessfully found"),
			@ApiResponse(code = 404, message = "room is not found give proper input")})
	@GetMapping("/getallrooms")
	public ResponseEntity<Responsestructure<List<Room>>> getallRooms()
	{
		return roomservice.getallRooms();
	}
}
