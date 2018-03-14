package ru.demi.java_examples.java_8.stream;

import java.util.Arrays;
import java.util.List;

/**
 * Created by demi
 * on 08.09.15.
 */
public class App06_reduce {
	public static void main(String[] args) {
		// Reduce operation merge all elements to single result.

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

		// first reduce method
		persons.stream()
			.reduce((p1, p2) -> p1.age > p2.age ? p1 : p2)
			.ifPresent(System.out::println);

		// second reduce
		// Второй Reduce метод принимает идентифицирующее значение и BinaryOperator.
		// Этот метод может быть использован для «создания» нового человека с агрегированным имен
		// и возрастом других человек в потоке:
		Person result = persons
			.stream()
			.reduce(new Person("", 0), (p1, p2) -> {
				p1.age += p2.age;
				p1.name += p2.name;
				return p1;
			});

		System.out.format("name=%s; age=%s%n", result.name, result.age);


		// third reduce
		// Третий Reduce  метод принимает три параметра: значение идентификатора,
		// BiFunction аккумулятор и объединитель функции типа BinaryOperator.
		// Поскольку идентифицирующее значение не ограничивает тип Person,
		// мы можем использовать это сокращение для определения суммы возрасте от всех лиц:
		Integer ageSum = persons
			.stream()
			.reduce(0, (sum, p) -> sum += p.age, (sum1, sum2) -> sum1 + sum2);

		System.out.println(ageSum);

		// Как видим, результат получился 78, но что же произошло под катом?
		// Давайте посмотрим вывод с подробным описанием:
		ageSum = persons
			.stream()
			.reduce(0,
				(sum, p) -> {
					System.out.format("accumulator: sum=%s; person=%s%n", sum, p);
					return sum += p.age;
				},
				(sum1, sum2) -> {
					System.out.format("combiner: sum1=%s; sum2=%s%n", sum1, sum2);
					return sum1 + sum2;
				});

		// Как видим, аккумулирующая функция делает всю работу.
		// Сначала вызывается инициализирующая значение 0 и первый человек Андрей.
		// В следующих трех вызовах “sum” увеличивается возраст до суммарного 78.

		// Подождите, что? Комбайнер никогда не вызывается? Выполнение этого стрима параллельно раскроет секрет:
		ageSum = persons
			.parallelStream()
			.reduce(0,
				(sum, p) -> {
					System.out.format("accumulator: sum=%s; person=%s\n", sum, p);
					return sum += p.age;
				},
				(sum1, sum2) -> {
					System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
					return sum1 + sum2;
				});
		System.out.println(ageSum);
		// Выполнение этого потока параллельно приведет к совершенно иным результатам.
		// Теперь комбайнер действительно вызывается. С тех пор как аккумулятор вызывается параллельно,
		// комбайнеру необходимо суммировать отдельные значения.
	}
}
