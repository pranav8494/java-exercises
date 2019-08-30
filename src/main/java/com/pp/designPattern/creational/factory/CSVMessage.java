package com.pp.designPattern.creational.factory;

public class CSVMessage implements Message {

	String firstName, lastName;
	
	public CSVMessage(String fName, String lName) {
		this.firstName = fName;
		this.lastName = fName;
	}
	
	@Override
	public String encodeMessage() {
		
		return firstName + "," + lastName;
	}

}
