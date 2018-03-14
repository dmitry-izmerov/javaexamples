package ru.demi.java_examples.java_8.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by demi
 * on 08.09.15.
 * <p>
 * https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html
 */
public class AppOracleDocs {

	public static void main(String[] args) {
		// Non-interference
		List<String> l = new ArrayList<>(Arrays.asList("One", "Two"));
		Stream<String> stream = l.stream();
		l.add("Three");
		String str = stream.collect(Collectors.joining(" "));
		System.out.println(str);

		// Side-effects
		List<String> l2 = new ArrayList<>(Arrays.asList("$One", "Two", "$Three"));
		stream = l2.stream();
		Pattern pattern = Pattern.compile("^\\$\\w+");
		ArrayList<String> results = new ArrayList<>();
		stream.filter(s -> pattern.matcher(s).matches())
			.forEach(s -> results.add(s));  // Unnecessary use of side-effects!

		// This code unnecessarily uses side-effects. If executed in parallel,
		// the non-thread-safety of ArrayList would cause incorrect results,
		// and adding needed synchronization would cause contention, undermining the benefit of parallelism.
		// Furthermore, using side-effects here is completely unnecessary;
		// the forEach() can simply be replaced with a reduction operation that is safer,
		// more efficient, and more amenable to parallelization:
		stream = l2.stream();
		List<String> list = stream.filter(s -> pattern.matcher(s).matches())
			.collect(Collectors.toList());  // No side-effects!
		System.out.println(list);

		List<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3));

		// usual sum
		int sum = 0;
		for (int x : numbers) {
			sum += x;
		}

		// However, there are good reasons to prefer a reduce operation over a mutative accumulation such as the above.
		// Not only is a reduction "more abstract" -- it operates on the stream as a whole rather than individual elements --
		// but a properly constructed reduce operation is inherently parallelizable,
		// so long as the function(s) used to process the elements are associative and stateless.
		// For example, given a stream of numbers for which we want to find the sum, we can write:
		sum = numbers.stream().reduce(0, (x, y) -> x + y);
		// or sum = numbers.stream().reduce(0, Integer::sum);
		System.out.println(sum);

		// in parallel
		sum = numbers.parallelStream().reduce(0, Integer::sum);
		System.out.println(sum);

		// Mutable reduction
		List<String> strings = new ArrayList<>(Arrays.asList("strin01", "string02", "string03"));
		String concatRes = strings.stream().reduce("", String::concat);
		System.out.println(concatRes);

		// As with reduce(), a benefit of expressing collect in this abstract way is that it is directly amenable to parallelization:
		// we can accumulate partial results in parallel and then combine them, so long as the accumulation and
		// combining functions satisfy the appropriate requirements. For example, to collect the String representations
		// of the elements in a stream into an ArrayList, we could write the obvious sequential for-each form:
		ArrayList<String> stringsList = new ArrayList<>();
		for (Integer element : numbers) {
			stringsList.add(element.toString());
		}

		// Or we could use a parallelizable collect form:
		strings = numbers.stream()
			.collect(() -> new ArrayList<>(), (c, e) -> c.add(e.toString()), (c1, c2) -> c1.addAll(c2));

		// or, pulling the mapping operation out of the accumulator function, we could express it more succinctly as:
		strings = numbers.stream().map(Object::toString)
			.collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

		// The three aspects of collect -- supplier, accumulator, and combiner -- are tightly coupled.
		// We can use the abstraction of a Collector to capture all three aspects.
		// The above example for collecting strings into a List can be rewritten using a standard Collector as:
		strings = numbers.stream().map(Object::toString)
			.collect(Collectors.toList());


	}
}
