package ru.demi.java_examples.java_core.multithreading.daemon;

/**
 * Created by demi
 * on 10.07.15.
 */
public class App01 {
	public static void main(String[] args) {
		Thread t = new Thread(() -> {
			while (true) ;
		});
		// thread is not daemon by default
		t.setDaemon(false);
		t.start();

		System.out.println("End Main Thread");
	}
}
