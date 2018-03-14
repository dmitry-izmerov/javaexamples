package ru.demi.java_examples.concurrent.executors;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author demi
 * @date 10.05.16
 */
public class InvokeAny {
	public static void main(String[] args) throws ExecutionException, InterruptedException {

		// Этот метод появился в Java 8 и ведет себя не так, как другие: вместо использования фиксированного количества
		// потоков он создает ForkJoinPool с определенным параллелизмом (parallelism size), по умолчанию равным
		// количеству ядер машины.
		ExecutorService executor = Executors.newWorkStealingPool();

		List<Callable<String>> callables = Arrays.asList(
			callable("task1", 2),
			callable("task2", 1),
			callable("task3", 3));

		String result = executor.invokeAny(callables);
		System.out.println(result);

		// => task2
	}

	public static Callable callable(String result, long sleepSeconds) {
		return () -> {
			TimeUnit.SECONDS.sleep(sleepSeconds);
			return result;
		};
	}
}
