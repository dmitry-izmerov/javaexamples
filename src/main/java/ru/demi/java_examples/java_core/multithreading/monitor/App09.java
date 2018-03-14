package ru.demi.java_examples.java_core.multithreading.monitor;

/**
 * Created by demi
 * on 11.07.15.
 */
public class App09 {
	public static void main(String[] args) {
		for (int i = 1; i <= 5; i++) {
			final int tmp = i;
			new Thread(new Runnable() {
				@Override
				public void run() {
					hello(tmp);
				}
			}).start();
		}
	}

	private synchronized static void hello(int id) {
		System.out.println("Thread id: " + id + " * - wait - sleep, " + System.currentTimeMillis());
		try {
			App09.class.wait(1000);
		} catch (InterruptedException ignore) {/*NOP*/}
		System.out.println("Thread id: " + id + " wait - * - sleep, " + System.currentTimeMillis());
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ignore) {/*NOP*/}
		System.out.println("Thread id: " + id + " wait - sleep - *, " + System.currentTimeMillis());
	}
}
