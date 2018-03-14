package ru.demi.java_examples.java_core.multithreading.deadlock;

/**
 * Created by demi
 * on 10.07.15.
 */
public class App02 {
	public static void main(String[] args) {
		final Thread[] threads = new Thread[2];
		threads[0] = new Thread(() -> {
			try {
				System.out.println("#0 join to #1");
				threads[1].join();
			} catch (InterruptedException e) {
			}
		});

		threads[1] = new Thread(() -> {
			try {
				System.out.println("#1 join to #0");
				threads[0].join();
			} catch (InterruptedException e) {
			}
		});
		threads[0].start();
		threads[1].start();
	}
}
