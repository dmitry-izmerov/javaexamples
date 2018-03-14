package ru.demi.java_examples.java_8.stream;

import java.util.function.Supplier;
import java.util.stream.Stream;

/**
 * Created by demi
 * on 08.09.15.
 */
public class App03_Order {
	public static void main(String[] args) {
		// Processing order
		Stream.of("some1", "some2", "else")
			.filter(s -> {
				System.out.println("Filter - " + s);
				return true;
			});

		Stream.of("some1", "some2", "else")
			.filter(s -> {
				System.out.println("Filter - " + s);
				return true;
			})
			.forEach(s -> System.out.println("print with help of forEach - " + s));

		Stream.of("dd2", "aa2", "bb1", "bb3", "cc4")
			.map(s -> {
				System.out.println("map: " + s);
				return s.toUpperCase();
			})
			.anyMatch(s -> {
				System.out.println("anyMatch: " + s);
				return s.startsWith("A");
			});

		System.out.println("Order of filter:");
		Stream.of("dd2", "aa2", "bb1", "bb3", "cc4")
			.map(s -> {
				System.out.println("map: " + s);
				return s.toUpperCase();
			})
			.filter(s -> {
				System.out.println("filter: " + s);
				return s.startsWith("A");
			})
			.forEach(s -> System.out.println("forEach: " + s));

		// optimize previous example
		Stream.of("dd2", "aa2", "bb1", "bb3", "cc4")
			.filter(s -> {
				System.out.println("filter: " + s);
				return s.startsWith("a");
			})
			.map(s -> {
				System.out.println("map: " + s);
				return s.toUpperCase();
			})
			.forEach(s -> System.out.println("forEach: " + s));

		System.out.printf("%nOrder of sorting:%n");
		Stream.of("dd2", "aa2", "bb1", "bb3", "cc4")
			.sorted((s1, s2) -> {
				System.out.printf("sort: %s; %s\n", s1, s2);
				return s1.compareTo(s2);
			})
			.filter(s -> {
				System.out.println("filter: " + s);
				return s.startsWith("a");
			})
			.map(s -> {
				System.out.println("map: " + s);
				return s.toUpperCase();
			})
			.forEach(s -> System.out.println("forEach: " + s));

		// optimize previous example
		Stream.of("dd2", "aa2", "bb1", "bb3", "cc4")
			.filter(s -> {
				System.out.println("filter: " + s);
				return s.startsWith("a");
			})
			.sorted((s1, s2) -> {
				System.out.printf("sort: %s; %s\n", s1, s2);
				return s1.compareTo(s2);
			})
			.map(s -> {
				System.out.println("map: " + s);
				return s.toUpperCase();
			})
			.forEach(s -> System.out.println("forEach: " + s));

		// method for reusing of stream
		Supplier<Stream<String>> streamSupplier =
			() -> Stream.of("dd2", "aa2", "bb1", "bb3", "cc")
				.filter(s -> s.startsWith("a"));

		streamSupplier.get().anyMatch(s -> true);   // операция пройдет успешно
		streamSupplier.get().noneMatch(s -> true);  // здесь также все будет ok

	}
}
