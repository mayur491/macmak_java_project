package com.macmak.java8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

public class StreamDemo {

	static Stream<String> listToStream(List<String> list) {
		return list == null || list.isEmpty() ? Stream.empty() : list.stream();
	}

	public static void main(String[] args) {

		List<String> list = new ArrayList<>();

		// 1. Empty Stream
		System.out.println(listToStream(list));

		// 2. Stream of Collection
		Collection<String> collection = Arrays.asList("a", "b", "c");
		System.out.println(collection.stream());

		// 3. Stream of Array
		String[] array = new String[] { "a", "b", "c" };
		// full array
		System.out.println(Arrays.stream(array));
		// part of array
		System.out.println(Arrays.stream(array, 1, 3));

		// 4. Stream.builder()
		System.out.println(Stream.<String>builder().add("a").add("b").add("c"));
		
		// 5. Stream.generate()
		System.out.println(Stream.generate(() -> "element").limit(10));
		
		// 6. Stream.iterate()
		System.out.println(Stream.iterate(40, n -> n + 2).limit(20));
		
		// 7. Stream of Primitives
		System.out.println(IntStream.range(1, 3));
		System.out.println(LongStream.rangeClosed(1, 3));
		Random random = new Random();
		System.out.println(random.doubles());
		
		// 8.
		
		
	}

}
