package com.pp.designPattern.creational.factory;

import java.util.Scanner;

public class DemoFactoryPattern {
	
	public static void main(String[] args){
	
		Scanner in = new Scanner(System.in);
		System.out.println("FirstName: ");
		String fName = in.next();
		System.out.println("LastName: ");
		String lName = in.next();
		in.close();
		
		MessageFactory factory = new MessageFactory();
		Message msg1 = factory.getMessage("csv", fName, lName);
		System.out.println("msg1: " + msg1.encodeMessage());
		
		Message msg2 = factory.getMessage("json", fName, lName);
		System.out.println("msg2: : " + msg2.encodeMessage());		
	}

}
