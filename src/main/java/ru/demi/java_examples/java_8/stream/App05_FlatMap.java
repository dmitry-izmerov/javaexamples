package ru.demi.java_examples.java_8.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * Created by demi
 * on 08.09.15.
 */
class Foo {
	String name;
	List<Bar> bars = new ArrayList<>();

	Foo(String name) {
		this.name = name;
	}
}

class Bar {
	String name;

	Bar(String name) {
		this.name = name;
	}
}

public class App05_FlatMap {
	public static void main(String[] args) {
		// FlatMap преобразует каждый элемент потока в поток других объектов.
		// Таким образом, каждый объект будет преобразован в ноль, один или несколько других объектов,
		// поддерживаемых потоком. Содержание этих потоков будет затем помещают в возвращаемом потоке flatMap операции.
		List<Foo> foos = new ArrayList<>();
		IntStream
			.range(1, 4)
			.forEach(i -> foos.add(new Foo("Foo" + i)));

		foos.forEach(f -> {
			IntStream
				.range(1, 4)
				.forEach(i -> f.bars.add(new Bar("Bar " + i + " <- " + f.name)));
		});

		foos.stream()
			.flatMap(f -> f.bars.stream())
			.forEach(b -> System.out.println(b.name));

		// Наконец, код выше можно упростить:
		IntStream.range(1, 4)
			.mapToObj(i -> new Foo("Foo" + i))
			.peek(f -> IntStream.range(1, 4)
				.mapToObj(i -> new Bar("Bar" + i + " <- " + f.name))
				.forEach(f.bars::add))
			.flatMap(f -> f.bars.stream())
			.forEach(b -> System.out.println(b.name));
	}
}
