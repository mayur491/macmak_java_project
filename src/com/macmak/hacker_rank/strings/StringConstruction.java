package com.macmak.hacker_rank.strings;

import java.util.Scanner;

/**
 * @author mayur.somani
 */

public class StringConstruction {

	// Complete the stringConstruction function below.
	static int stringConstruction(String s) {

		return (int)s.chars().distinct().count();
		
	}

	private static final Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		
		int result = 0;
		int q = scanner.nextInt();
		scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

		for (int qItr = 0; qItr < q; qItr++) {
			
			String s = scanner.nextLine();
			result = stringConstruction(s);

		}

		System.out.println("Result: " + result);
		scanner.close();
	}

}
