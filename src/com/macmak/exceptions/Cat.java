package com.macmak.exceptions;

import java.io.IOException;

public class Cat implements Animal {

	/*
	 * Case1: Parent->No Exception, Child->No Exception
	 */
	@Override
	public void eat() {
		System.out.println("Cat is eating...");
	}

	/*
	 * Case4: Parent->Checked Exception, Child->Checked Exception (same)
	 */
	@Override
	public void sleep() throws IOException, NullPointerException{
		System.out.println("Cat is sleeping...");
	}

}
