package ru.demi.java_examples.java_8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by demi
 * on 07.09.15.
 * <p>
 * From http://prologistic.com.ua/polnoe-rukovodstvo-po-java-8-stream.html
 */
public class App01 {
	public static void main(String[] args) {
		List<String> strings = new ArrayList<>();
		strings.add("Hello");
		strings.add("World");
		strings.add("!");
		strings.add("We love");
		strings.add("Java 8");

		// filter
		strings.stream()
			.filter(s -> s.startsWith("W"))
			.forEach(System.out::println);

		// sorting
		strings
			.stream()
			.sorted()
			.filter(s -> s.startsWith("W"))
			.forEach(System.out::println);

		// map
		strings = new ArrayList<>();
		strings.add("1");
		strings.add("2");
		strings.add("3");
		strings.add("4");
		strings.add("5");

		strings
			.stream()
			.sorted()
			.map(s -> Integer.parseInt(s) + 10)
			.forEach(i -> System.out.println(i.getClass().getName()));

		// match
		boolean allMatch = strings
			.stream()
			.allMatch(s -> s.startsWith("1"));
		System.out.println(allMatch);

		boolean anyMatch = strings
			.stream()
			.anyMatch(s -> s.startsWith("1"));
		System.out.println(anyMatch);

		boolean noneMatch = strings
			.stream()
			.noneMatch(s -> s.startsWith("9"));
		System.out.println(noneMatch);


		// count
		long count = strings
			.stream()
			.map(Long::valueOf)
			.filter(i -> i.equals(2L))
			.count();
		System.out.println(count);


		// parallel streams !!!
		System.out.println();
		List<Integer> integers = new ArrayList<>();

		for (int i = 0; i < 10; i++) {
			integers.add((int) (Math.random() * 10));
		}

		integers
			.parallelStream()
			.filter(i -> i % 2 == 0)
			.sorted()
			// without order!
			// .forEach(System.out::println);
			.forEachOrdered(System.out::println);
	}
}
