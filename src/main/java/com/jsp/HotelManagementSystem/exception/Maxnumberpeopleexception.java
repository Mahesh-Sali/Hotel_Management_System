package com.jsp.HotelManagementSystem.exception;

public class Maxnumberpeopleexception extends RuntimeException
{
     private String message="we cant have these many number of people in the selected room";

	@Override
	public String getMessage() {
		 return message;
		 
	}
	

	public Maxnumberpeopleexception(String message) {
		super();
		this.message = message;
	}


	public Maxnumberpeopleexception() {
		super();
		// TODO Auto-generated constructor stub
	}

	
     
}
