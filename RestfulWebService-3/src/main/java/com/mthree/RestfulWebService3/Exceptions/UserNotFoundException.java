package com.mthree.RestfulWebService3.Exceptions;

public class UserNotFoundException extends RuntimeException {

	public UserNotFoundException(String message) {
		super(message);
		
		System.out.println("Insdie it");
		
	}

	
	
}
