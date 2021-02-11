package com.macmak.exceptions;

import java.io.FileNotFoundException;

public class Dog implements Animal {

	/*
	 * Case2: Parent->No Exception, Child->Checked Exception (error)
	 */
	@Override
	// public void eat() throws IOException {
	public void eat() {
		System.out.println("Dog is eating...");
	}

	/*
	 * Case5: Parent->Checked Exception, Child->Sub-Type of Checked Exception.
	 */
	@Override
	public void sleep() throws FileNotFoundException {
		System.out.println("Dog is sleeping...");
	}

	
	
}
