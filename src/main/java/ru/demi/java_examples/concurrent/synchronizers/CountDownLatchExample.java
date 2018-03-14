package ru.demi.java_examples.concurrent.synchronizers;

import java.util.concurrent.CountDownLatch;

/**
 * Created by demi
 * on 05.01.16.
 */
public class CountDownLatchExample {

	public static void main(String[] args) {
		final CountDownLatch countDownLatch = new CountDownLatch(3);
		new Thread(() -> {
			System.out.println("awaiting...");
			try {
				countDownLatch.await();
			} catch (InterruptedException e) {
				System.out.println("await has been interrupted.");
				return;
			}
			System.out.println("ready");
		}).start();

		for (int i = 0; i < 5; i++) {
			final int index = i;
			new Thread(new Runnable() {
				@Override
				public void run() {
					System.out.println("T" + index + " - countdown");
					countDownLatch.countDown();
					System.out.println("T" + index + " - continue");
					//System.out.println(countDownLatch);
				}
			}).start();
		}
	}
}
