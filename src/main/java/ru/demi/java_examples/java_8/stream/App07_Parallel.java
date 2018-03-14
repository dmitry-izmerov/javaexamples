package ru.demi.java_examples.java_8.stream;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

/**
 * Created by demi
 * on 09.09.15.
 */
public class App07_Parallel {
	public static void main(String[] args) {
		// Потоки могут быть выполнены параллельно, чтобы увеличить производительность выполнения
		// на большом количестве входных элементов. Параллельные потоки используют общий ForkJoinPool доступный через
		// статический ForkJoinPool.commonPool() метод. Размер основного пула потоков использует до пяти нитей –
		// в зависимости от количества доступных физических ядер процессора:
		ForkJoinPool commonPool = ForkJoinPool.commonPool();
		System.out.println(commonPool.getParallelism());

		// Коллекции поддерживает метод parallelStream(), чтобы создать параллельный поток элементов.
		// Кроме того, вы можете вызвать промежуточный метод parallel() на данном потоке,
		// чтобы преобразовать последовательный поток в параллельной копии.
		Arrays.asList("a1", "b1", "b2", "a2")
			.parallelStream()
			.filter(s -> {
				System.out.format("filter: %s [%s]%n", s, Thread.currentThread().getName());
				return true;
			})
			.map(s -> {
				System.out.format("map: %s [%s]%n", s, Thread.currentThread().getName());
				return s.toUpperCase();
			})
			.forEach(s -> System.out.format("forEach: %s [%s]%n", s, Thread.currentThread().getName()));

		Arrays.asList("a1", "a2", "b1", "c2", "c1")
			.parallelStream()
			.filter(s -> {
				System.out.format("filter: %s [%s]%n", s, Thread.currentThread().getName());
				return true;
			})
			.map(s -> {
				System.out.format("map: %s [%s]%n", s, Thread.currentThread().getName());
				return s.toUpperCase();
			})
			.sorted((s1, s2) -> {
				System.out.format("sort: %s <> %s [%s]%n", s1, s2, Thread.currentThread().getName());
				return s1.compareTo(s2);
			})
			.forEach(s -> System.out.format("forEach: %s [%s]%n", s, Thread.currentThread().getName()));

		// Кажется, что sort выполняется последовательно только основной нитью.
		// Но это не так. На самом деле, sort на параллельном потоке использует
		// новый Java 8 метод Arrays.parallelSort() под капотом. Имейте в виду, что отладочный вывод
		// относится только к исполнению переданного лямбда-выражения.
		// Так, sort компаратор выполнен только на главном потоке, но фактическое алгоритм
		// сортировки выполняется параллельно.


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
				new Person("Vitya", 12)
			);

		persons
			.parallelStream()
			.reduce(0,
				(sum, p) -> {
					System.out.format("accumulator: sum=%s; person=%s [%s]%n", sum, p, Thread.currentThread().getName());
					return sum += p.age;
				},
				(sum1, sum2) -> {
					System.out.format("combiner: sum1=%s; sum2=%s [%s]%n", sum1, sum2, Thread.currentThread().getName());
					return sum1 + sum2;
				});
	}
}
