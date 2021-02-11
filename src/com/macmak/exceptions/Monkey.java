package com.macmak.exceptions;

public class Monkey implements Animal {

	/*
	 * Case3: Parent->No Exception, Child->Unchecked Exception
	 */
	@Override
	public void eat() throws NullPointerException {
		System.out.println("Monkey is eating...");
	}

	/*
	 * Case6: Parent->Checked Exception, Child->Super-Type of Checked Exception
	 */
	@Override
	// public void sleep() throws Exception {
	public void sleep() {
		System.out.println("Monkey is sleeping...");
	}

}
