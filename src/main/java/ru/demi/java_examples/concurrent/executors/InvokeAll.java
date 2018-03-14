package ru.demi.java_examples.concurrent.executors;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author demi
 * @date 10.05.16
 */
public class InvokeAll {
	public static void main(String[] args) throws InterruptedException {

		// Этот метод появился в Java 8 и ведет себя не так, как другие: вместо использования фиксированного количества
		// потоков он создает ForkJoinPool с определенным параллелизмом (parallelism size), по умолчанию равным
		// количеству ядер машины.
		ExecutorService executor = Executors.newWorkStealingPool();

		List<Callable<String>> tasks = Arrays.asList(
			() -> "task1",
			() -> "task2",
			() -> "task3"
		);

		executor.invokeAll(tasks)
			.stream()
			.map(future -> {
				try {
					return future.get();
				} catch (Exception e) {
					throw new IllegalStateException(e);
				}
			})
			.forEach(System.out::println);
	}
}
