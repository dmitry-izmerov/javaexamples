package ru.demi.java_examples.concurrent.executors;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author demi
 * @date 10.05.16
 */
public class SimpleExecutor {
	public static void main(String[] args) {
		ExecutorService executor = Executors.newSingleThreadExecutor();
		try {
			executor.submit(() -> {
				try {
					TimeUnit.SECONDS.sleep(3);
				} catch (InterruptedException e) {
					System.out.println(Thread.currentThread().getName() + " is interrupted.");
				}
				System.out.println("Hello " + Thread.currentThread().getName());
			});

			executor.shutdown();
			executor.awaitTermination(2, TimeUnit.SECONDS);
		} catch (InterruptedException e) {
			System.err.println("Task is interrupted.");
		} finally {
			if (!executor.isTerminated()) {
				System.err.println("Cancel non-finished tasks.");
				executor.shutdownNow();
			}
			System.out.println("Shutdown is finished.");
		}
	}
}
