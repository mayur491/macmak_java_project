package com.macmak.exceptions;

import java.io.IOException;

interface Animal {

	/**
	 * <p>
	 * If <b>super class</b> method has not declared any exception using <b>throws
	 * clause</b> then subclass overridden method <b>cannot declare any checked
	 * exception</b> <i>example Cat->eat() throws IOException {...}</i> but it
	 * <b>can declare unchecked exception</b> with the throws clause <i>example
	 * Dog->eat() throws NullPointerException {...}</i>
	 * </p>
	 */
	public void eat();

	/**
	 * <p>
	 * If <b>super class</b> method has declared a checked exception using throws
	 * clause then subclass overridden method can do <b>one of the three things</b>.
	 * </p>
	 * <p>
	 * 1. Sub-class can declare the same exception as declared in the super-class
	 * method. <i>example Cat->sleep() throws IOException {...}</i>
	 * </p>
	 * <p>
	 * 2. Sub-class can declare the sub-type exception of the exception declared in
	 * the super-class method; <i>example Cat->sleep() throws FileNotFoundException
	 * {...}</i> But sub-class cannot declare any exception that is up in the
	 * hierarchy than the exception declared in the super-class method. <i>example
	 * Cat->sleep() throws Exception {...} </i>
	 * </p>
	 * <p>
	 * 3. Sub-class method can choose not to declare any exception at all. <i>example Cat->sleep</i>
	 * </p>
	 * 
	 * @throws IOException
	 */
	public void sleep() throws IOException;

}
