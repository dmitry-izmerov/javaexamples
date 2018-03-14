package ru.demi.java_examples.java_8.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;

/**
 * Created by demi
 * on 03.09.15.
 */
public class Java_8_Lambda {
	public static void main(String[] args) {
		List<Object> objects = Arrays.asList(new Object(), new Object(), new Object());

		// standard approach
		for (Object object : objects) {
			System.out.println(object);
		}

		// new approach
		objects.forEach(obj -> System.out.println(obj));

		// analogous functional
		objects.forEach(new Consumer<Object>() {
			@Override
			public void accept(Object o) {
				System.out.println(o);
			}
		});

		// using method reference
		objects.forEach(System.out::println);


		Comparator<Integer> comparator = new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return (a < b) ? -1 : ((a > b) ? 1 : 0);
			}
		};
		Comparator<Integer> comparatorLambda = (a, b) -> (a < b) ? -1 : ((a > b) ? 1 : 0);

		// return are necessary for multiline expression
		Comparator<Integer> comparatorLambdaWithReturn = (Integer a, Integer b) -> {
			return (a < b) ? -1 : ((a > b) ? 1 : 0);
		};
	}
}
