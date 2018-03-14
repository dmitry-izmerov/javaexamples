package ru.demi.java_examples.java_8.stream;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

/**
 * Created by demi
 * on 08.09.15.
 */
public class App04_Collect {
	public static void main(String[] args) {
		class Person {
			String name;
			int age;

			Person(String name, int age) {
				this.name = name;
				this.age = age;
			}

			@Override
			public String toString() {
				return name;
			}
		}

		List<Person> persons =
			Arrays.asList(
				new Person("Andrew", 20),
				new Person("Igor", 23),
				new Person("Ira", 23),
				new Person("Vitia", 12)
			);

		// Collect является чрезвычайно полезной операцией, чтобы превратить элементы потока в List, Set или Map.
		// Collect принимает Collector, который состоит из четырех различных операций:
		// поставщик, аккумулятор, объединитель и финишер.

		List<Person> filtered = persons
			.stream()
			.filter(person -> person.name.startsWith("I"))
			.collect(Collectors.toList());

		System.out.println(filtered);

		Map<Integer, List<Person>> personsByAge = persons
			.stream()
			.collect(Collectors.groupingBy(p -> p.age));

		personsByAge.forEach((age, list) -> System.out.printf("age %s: %s%n", age, list));

		// average age
		Double averageAge = persons.stream().collect(Collectors.averagingInt(p -> p.age));
		System.out.println(averageAge);

		// summary info
		IntSummaryStatistics ageSummary =
			persons
				.stream()
				.collect(Collectors.summarizingInt(p -> p.age));

		System.out.println(ageSummary);

		String phrase = persons
			.stream()
			.filter(p -> p.age >= 18)
			.map(p -> p.name)
			.collect(Collectors.joining(" and ", "All of us -  ", " are adult."));

		System.out.println(phrase);

		// to map
		Map<Integer, String> map = persons
			.stream()
			.collect(Collectors.toMap(
				p -> p.age,
				p -> p.name,
				(name1, name2) -> name1 + ";" + name2)
			);

		System.out.println(map);

		// Теперь, когда мы знаем, некоторые мощные встроенные коллекторы,
		// давайте попробуем построить свой собственный специальный коллектор.
		// Мы хотим превратить всех людей в потоке в одну строку,
		// состоящую из всех имен в верхнем регистре, разделенных знаком "|".

		// Для достижения этого мы создаем новый коллектор через Collector.of().
		// Мы должны пройти четыре этапа использования collectors: supplier, accumulator, combiner и finisher.

		// Так как строки в Java неизменные, нам нужен вспомогательный класс StringJoiner,
		// чтобы коллектор мог построить нашу строку.
		// Supplier изначально создает такой​ StringJoiner с соответствующим разделителем.
		// Accumulator используется для добавления имени каждого человека в верхний регистр.
		// Combiner знает как объединить два StringJoiner в один.
		// На последнем этапе Finisher строит желаемую строку из StringJoiner.

		Collector<Person, StringJoiner, String> personNameCollector =
			Collector.of(
				() -> new StringJoiner(" | "),          // supplier
				(j, p) -> j.add(p.name.toUpperCase()),  // accumulator
				(j1, j2) -> j1.merge(j2),               // combiner
				StringJoiner::toString                  // finisher
			);

		String names = persons
			.stream()
			.collect(personNameCollector);

		System.out.println(names);
	}
}
