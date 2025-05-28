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

import com.jsp.HotelManagementSystem.dto.Customer;
import com.jsp.HotelManagementSystem.service.Customerservice;
import com.jsp.HotelManagementSystem.util.Responsestructure;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

@RestController
@RequestMapping("/customer")
public class Customercontroller 
{
	@Autowired
	private Customerservice customerservice;

	@ApiOperation(value = "save customer",notes = "api is used for save customer")
	@ApiResponses(value = {@ApiResponse(code = 201 ,message = "customer sucessfully saved"),
			@ApiResponse(code = 404, message = "customer is not saved give proper input")})
	@PostMapping
	public ResponseEntity<Responsestructure<Customer>> saveCustomer(@RequestBody Customer customer) {
		return customerservice.saveCustomer(customer);

	}

	@ApiOperation(value = "update customer",notes = "api is used for update customer")
	@ApiResponses(value = {@ApiResponse(code = 200 ,message = "customer sucessfully saved"),
			@ApiResponse(code = 404, message = "customer is not updated give proper input")})
	@PutMapping
	public ResponseEntity<Responsestructure<Customer>> updateCustomer(@RequestParam int cid, @RequestBody Customer customer) {
		return customerservice.updateCustomer(cid, customer);

	}

	@ApiOperation(value = "delete customer",notes = "api is used for delete customer")
	@ApiResponses(value = {@ApiResponse(code = 200 ,message = "customer sucessfully deleted"),
			@ApiResponse(code = 404, message = "customer is not deleted give proper input")})
	@DeleteMapping
	public ResponseEntity<Responsestructure<Customer>> deleteCustomer(@RequestParam int cid) {
		return customerservice.deleteCustomer(cid);

	}

	@ApiOperation(value = "get customer by id",notes = "api is used for get customer details by id")
	@ApiResponses(value = {@ApiResponse(code = 302 ,message = "customer data found sucessfully"),
			@ApiResponse(code = 404, message = "customer is not found give proper input")})
	@GetMapping
	public ResponseEntity<Responsestructure<Customer>> getCustomerbyid(@RequestParam int cid) {
		return customerservice.getCustomerbyid(cid);

	}

	@ApiOperation(value = "get customer by email",notes = "api is used for get customer details by email")
	@ApiResponses(value = {@ApiResponse(code = 302 ,message = "customer data found sucessfully"),
			@ApiResponse(code = 404, message = "customer is not found give proper input")})
	@GetMapping("/customerbyemail")
	public ResponseEntity<Responsestructure<Customer>> getCustomerbyemail(@RequestParam String c_email) {
		return customerservice.getCustomerbyemail(c_email);

	}

	@ApiOperation(value = "get all customer",notes = "api is used for get all customer")
	@ApiResponses(value = {@ApiResponse(code = 302 ,message = "customer data found sucessfully"),
			@ApiResponse(code = 404, message = "customer is not found give proper input")})
	@GetMapping("/getallcustomers")
	public ResponseEntity<Responsestructure<List<Customer>>> getallcustomer() {
		return customerservice.getallCustomers();
	}
	
	@ApiOperation(value = "login customer",notes = "api is used for login customer")
	@ApiResponses(value = {@ApiResponse(code = 302 ,message = "customer loggedin sucessfully"),
			@ApiResponse(code = 404, message = "customer is not loggedin give proper input")})
	@GetMapping("/customerlogin")
	public ResponseEntity<Responsestructure<Customer>> loginCustomer(@RequestParam String email, @RequestParam String password) {
		return customerservice.loginCustomer(email, password);

	}
	 
}
