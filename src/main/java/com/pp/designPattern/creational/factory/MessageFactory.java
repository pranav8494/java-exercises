package com.pp.designPattern.creational.factory;import org.checkerframework.checker.units.qual.m;

public class MessageFactory {
	
	public Message getMessage(String messageType, String firstName, String lastName) {
		
		if("csv".equals(messageType)){
			return new CSVMessage(firstName, lastName);
		}
		else if ("json".equals(messageType)){
			return new jsonMessage(firstName, lastName);
		}
		else{
			return null;
		}
	}
}
