package ru.demi.java_examples.java_core.multithreading;

/**
 * Created by demi
 * on 10.07.15.
 * <p>
 * Incorrect program
 */
public class App01 {
	private static final int N = 200_000;
	// non volatile field - all the same
	public static int counter = 0;

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(() -> {
			for (int i = 0; i < N; i++) {
				// не атомарная операция!!!
				//synchronized (App01.class) {
				++counter;
				//}
			}
		});
		t1.start();

		Thread t2 = new Thread(() -> {
			for (int i = 0; i < N; i++) {
				//synchronized (App01.class) {
				--counter;
				//}
			}
		});
		t2.start();

		t1.join();
		t2.join();

		System.out.println(counter);
	}
}
