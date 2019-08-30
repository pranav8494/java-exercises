package com.pp.designPattern.creational.factory;

public class jsonMessage implements Message {
	String firstName, lastName;
	
	public jsonMessage(String fName, String lName) {
		this.firstName = fName;
		this.lastName = fName;
	}
	
	@Override
	public String encodeMessage() {
		
		return "{firstName: " + firstName + ", lastName: " + lastName + "}";
	}
}
