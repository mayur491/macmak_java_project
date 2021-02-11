package com.macmak.java8.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class OptionalDemo {

	public static void main(String[] args) {

		// 1. Optional.empty
		System.out.println(Optional.empty());

		// 2. Optional.of
		String nonNullString = "value";
		System.out.println(Optional.of(nonNullString));

		// 3. Optional.ofNullable
		String nullString = null;
		System.out.println(Optional.ofNullable(nullString));

		// ----------------------USAGE----------------------

		Optional<List> optional = Optional.ofNullable(getList());

	}

	private static List<String> getList() {
		List<String> list = new ArrayList<>();
		list.add("value");
		return list;
	}

	private static boolean print(String str) {
		if (str != null && !str.isBlank()) {
			System.out.println(str);
			return true;
		} else {
			return false;
		}
	}

}
