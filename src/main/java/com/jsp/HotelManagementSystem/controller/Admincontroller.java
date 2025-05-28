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

import com.jsp.HotelManagementSystem.dto.Admin;
import com.jsp.HotelManagementSystem.dto.Hotel;
import com.jsp.HotelManagementSystem.service.Adminservice;
import com.jsp.HotelManagementSystem.util.Responsestructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/admin")
public class Admincontroller 
{
	@Autowired
    private Adminservice adminservice;
	
	@ApiOperation(value = "save admin",notes = "api is used for save admin")
	@ApiResponses(value = {@ApiResponse(code = 201 ,message = "admin sucessfully saved"),
			@ApiResponse(code = 404, message = "admin is not saved give proper input")})
	@PostMapping
	public ResponseEntity<Responsestructure<Admin>> saveAdmin(@RequestBody Admin admin,@RequestParam int hid)
	{
		return adminservice.saveAdmin(admin, hid);
	}
	@ApiOperation(value = "update admin",notes = "api is used for update admin")
	@ApiResponses(value = {@ApiResponse(code = 200 ,message = "admin sucessfully updated"),
			@ApiResponse(code = 404, message = "admin is not updated give proper input")})
	@PutMapping
	public ResponseEntity<Responsestructure<Admin>> updateAdmin(@RequestBody Admin admin,@RequestParam int aid)
	{
		return adminservice.updateAdmin(aid, admin);
	}
	@ApiOperation(value = "delete admin",notes = "api is used for delete admin")
	@ApiResponses(value = {@ApiResponse(code = 200 ,message = "admin sucessfully deleted"),
			@ApiResponse(code = 404, message = "admin is not deleted give proper input")})
	@DeleteMapping
	public ResponseEntity<Responsestructure<Admin>> deleteAdmin(@RequestParam int aid)
	{
		return adminservice.deleteAdmin(aid);
	}
	@ApiOperation(value = "get admin by id",notes = "api is used for get admin details based on id")
	@ApiResponses(value = {@ApiResponse(code = 302 ,message = "admin data found sucessfully"),
			@ApiResponse(code = 404, message = "admin is not found give proper input")})
	@GetMapping("/adminbyid")
	public ResponseEntity<Responsestructure<Admin>> getAdminbyid(@RequestParam int aid)
	{
		return adminservice.getAdminbyid(aid);
	}
	@ApiOperation(value = "get admin by email",notes = "api is used for get admin details based on email")
	@ApiResponses(value = {@ApiResponse(code = 302 ,message = "admin data found sucessfully"),
			@ApiResponse(code = 404, message = "admin is not found give proper input")})
	@GetMapping("/adminbyemail")
	public ResponseEntity<Responsestructure<Admin>> getAdminbyemail(@RequestParam String email)
	{
		 return adminservice.getadminbyemail(email); 
	}
	@ApiOperation(value = "get all admin",notes = "api is used for get all admin details")
	@ApiResponses(value = {@ApiResponse(code = 302 ,message = "admin data found sucessfully"),
			@ApiResponse(code = 404, message = "admin is not found give proper input")})
	@GetMapping("/getalladmin")
	public ResponseEntity<Responsestructure<List<Admin>>> getallAdmin()	
	{
		return adminservice.getallAdmin();
	}
	@ApiOperation(value = "login admin",notes = "api is used for login admin")
	@ApiResponses(value = {@ApiResponse(code = 302 ,message = "admin loggedin sucessfully"),
			@ApiResponse(code = 404, message = "admin is not loggedin give proper input")})
	@GetMapping("/loginadmin")
	public ResponseEntity<Responsestructure<Admin>> loginAdmin(@RequestParam String email,@RequestParam String password)
	{
		return adminservice.loginAdmin(email, password);
	}
}
