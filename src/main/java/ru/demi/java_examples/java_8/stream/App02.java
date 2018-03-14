package ru.demi.java_examples.java_8.stream;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Created by demi
 * on 07.09.15.
 */
public class App02 {
	public static void main(String[] args) {
		Arrays.asList("c1", "c2", "c3")
			.stream()
			.findFirst()
			.ifPresent(System.out::println);

		Stream.of("a", "b", "c")
			.findFirst()
			.ifPresent(System.out::println);

		IntStream.range(1, 5)
			.forEach(System.out::println);

		Arrays.stream(new int[]{1, 2, 3})
			.map(n -> n * 2)
			.average()
			.ifPresent(System.out::println);

		Stream.of("i1", "some2", "thing5")
			.map(s -> s.substring(s.length() - 1))
			.mapToInt(Integer::parseInt)
			.max()
			.ifPresent(System.out::println);

		IntStream.range(1, 4)
			.mapToObj(i -> "string" + i)
			.forEach(System.out::println);

		Stream.of(1.0, 2.0, 4.0)
			.mapToInt(Double::intValue)
			.mapToObj(i -> "s " + i)
			.forEach(System.out::println);
	}
}
