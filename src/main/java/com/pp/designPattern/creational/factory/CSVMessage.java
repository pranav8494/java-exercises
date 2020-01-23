package com.pp.designPattern.creational.factory;

public class CSVMessage extends Message {

	String firstName, lastName;
	
	public CSVMessage(String fName, String lName) {
		this.firstName = fName;
		this.lastName = lName;
	}
	
	@Override
	public String encodeMessage() {
		
		return firstName + "," + lastName;
	}

}
