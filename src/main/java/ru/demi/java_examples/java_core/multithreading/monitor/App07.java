package ru.demi.java_examples.java_core.multithreading.monitor;

/**
 * Created by demi
 * on 11.07.15.
 */
public class App07 {
	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				hello(1);
			}
		});
		Thread t2 = new Thread(new Runnable() {
			@Override
			public void run() {
				hello(2);
			}
		});

		t1.start();
		t2.start();
	}

	private synchronized static void hello(int id) {
		System.out.println("Thread id-" + id + " is here");
		try {
			Thread.sleep(2000);
		} catch (InterruptedException ignore) {/*NOP*/}
	}
}
