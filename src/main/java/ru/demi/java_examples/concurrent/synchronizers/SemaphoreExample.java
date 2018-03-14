package ru.demi.java_examples.concurrent.synchronizers;

import java.util.concurrent.Semaphore;

/**
 * Created by demi
 * on 05.01.16.
 */
public class SemaphoreExample {

	public static void main(String[] args) {
		final Semaphore semaphore = new Semaphore(1);

		acquire("T1", semaphore);
		acquire("T2", semaphore);

		release("T3", semaphore);
		release("T4", semaphore);
	}

	private static void acquire(final String id, Semaphore semaphore) {
		new Thread(() -> {
			try {
				System.out.println("Thread" + id + " tries to acquire the semaphore.");
				semaphore.acquire();
			} catch (InterruptedException e) {
				System.out.println("Thread" + id + " is interrupted.");
			}
			System.out.println("Thread" + id + " acquired the semaphore.");
		}).start();
	}

	private static void release(String id, Semaphore semaphore) {
		new Thread(() -> {
			System.out.println("Thread" + id + " tries to release semaphore.");
			semaphore.release();
			System.out.println("Thread" + id + " released semaphore.");
		}).start();
	}
}
