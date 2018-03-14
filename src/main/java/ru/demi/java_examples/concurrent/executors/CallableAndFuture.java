package ru.demi.java_examples.concurrent.executors;

import java.util.concurrent.*;

/**
 * @author demi
 * @date 10.05.16
 */
public class CallableAndFuture {
	public static void main(String[] args) throws ExecutionException, InterruptedException {
		Callable<Integer> task = () -> {
			try {
				TimeUnit.SECONDS.sleep(2);
				return 100;
			} catch (InterruptedException e) {
				throw new IllegalStateException("Task is interrupted", e);
			}
		};

		ExecutorService executor = Executors.newFixedThreadPool(1);
		Future<Integer> future = executor.submit(task);

		System.out.println("Future done? " + future.isDone());

		// thread is blocked here!
		//executor.shutdownNow();
		Integer res = future.get();

		System.out.println("Future done? " + future.isDone());
		System.out.println("Result: " + res);

		//executor.shutdown();
	}
}
