package ru.demi.java_examples.concurrent.synchronizers;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by demi
 * on 05.01.16.
 */
public class CyclicBarrierExample {

	public static void main(String[] args) throws InterruptedException {
		final CyclicBarrier cyclicBarrier = new CyclicBarrier(5);
		for (int i = 0; i < 10; i++) {
			final int index = i;
			new Thread(() -> {
				System.out.println("Thread-" + index + " - await");
				try {
					cyclicBarrier.await();
				} catch (InterruptedException e) {
					System.out.println("Thread-" + index + " - is interrupted");
				} catch (BrokenBarrierException e) {
					System.out.println("Thread-" + index + " - barrier is broken");
				}
				System.out.println("Thread-" + index + " - continue");
			}).start();
			Thread.sleep(500);
		}
	}
}
